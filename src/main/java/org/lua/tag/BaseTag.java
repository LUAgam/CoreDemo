/**
 * 
 */
package org.lua.tag;

import org.lua.annotation.Show;
import org.lua.util.ReflectUtil;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/** 
* @author AMGuo E-mail:www.guoao@foxmail.com 
* @version 创建时间：2017年4月1日 下午2:41:08 
* 类说明 
*/
/**
 * tag基础类：doStartTag返回ShowItem的集合
 * @author LUA
 *
 */
public abstract class BaseTag extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3620478428576630543L;

	/**
	 * 前台传来的对象
	 */
	Object value;
	
	/**
	 * 标题
	 */
	String title;
	
	/**
	 * 面板颜色
	 */
	String color;

	/**
	 * 类中有show注解的个数
	 */
	int num = 0;

	List<ShowItem> showItemList = new ArrayList<ShowItem>();

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public int doStartTag() throws JspException {
		showItemList = new ArrayList<ShowItem>();
		num = 0;
		Field[] fields = value.getClass().getDeclaredFields();

		// 取得name对应的值
		for (Field f : fields) {
			Show show = f.getAnnotation(Show.class);
			if (show != null) {
				String name = f.getName();
				String attrValue = null;
				try {
					attrValue = ReflectUtil.getValue(name, value);
				} catch (Exception e) {
					e.printStackTrace();
				}
				showItemList.add(new ShowItem(show.title(), attrValue, show.pos(), show.colspan()));
				num++;
			}
		}
		// 根据pos顺序排序
		for (int i = 0; i < showItemList.size() - 1; i++) {
			for (int j = i + 1; j < showItemList.size(); j++) {
				ShowItem showItem = showItemList.get(i);
				ShowItem minShowItem = showItemList.get(j);
				if (showItem.getPos() >= minShowItem.getPos()) {
					showItemList.set(i, minShowItem);
					showItemList.set(j, showItem);
				}
			}
		}
		return super.doStartTag();
	}

}
