/**
 * 
 */
package org.lua.tag;

/** 
* @author AMGuo E-mail:www.guoao@foxmail.com 
* @version 创建时间：2017年4月1日 下午2:42:53 
* 类说明 
*/
/**
 * doEndTag处理的对象 对应属性为注解show的全部属性
 * 
 * @author LUA
 *
 */
public class ShowItem extends Item {

	private Integer colspan;

	public ShowItem(String title, String value, Integer pos, Integer colspan) {
		super(title, value, pos);
		this.colspan = colspan;
	}

	public ShowItem() {
		super();
	}

	public Integer getColspan() {
		return colspan;
	}

	public void setColspan(Integer colspan) {
		this.colspan = colspan;
	}
}
