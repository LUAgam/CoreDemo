/**
 * 
 */
package org.lua.tag;

/** 
* @author AMGuo E-mail:www.guoao@foxmail.com 
* @version 创建时间：2017年4月1日 下午2:43:26 
* 类说明 
*/
/**
 * tag基本输出
 * 
 * @author LUA
 *
 */
public class Item {

	/**
	 * label值
	 */
	String title;

	/**
	 * value值
	 */
	String value;
	
	/**
	 * 显示的顺序
	 */
	Integer pos;
	
	public Item() {
		super();
	}

	public Item(String title, String value, Integer pos) {
		super();
		this.title = title;
		this.value = value;
		this.pos = pos;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Integer getPos() {
		return pos;
	}

	public void setPos(Integer pos) {
		this.pos = pos;
	}

}
