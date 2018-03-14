/**
 * 
 */
package org.lua.tag;

import org.lua.util.ReflectUtil;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import java.io.IOException;


/** 
* @author AMGuo E-mail:www.guoao@foxmail.com 
* @version 创建时间：2017年4月1日 下午4:47:32 
* 类说明 
*/
/**
 * @author LUA
 *
 */
public class StateProgress extends BaseTag {

	private static final long serialVersionUID = 224604043211249854L;

	/**
	 * 对应实体中状态对应的name
	 */
	String statusKey;

	/**
	 * 对应实体中状态集合的name
	 */
	String statesKey;

	String[] statesValue;

	String statusValue;

	public String getStatusKey() {
		return statusKey;
	}

	public void setStatusKey(String statusKey) {
		this.statusKey = statusKey;
	}

	public String getStatesKey() {
		return statesKey;
	}

	public void setStatesKey(String statesKey) {
		this.statesKey = statesKey;
	}

	@Override
	public int doStartTag() throws JspException {
		try {
			@SuppressWarnings("rawtypes")
			Class clz = value.getClass();
			statesValue = (String[]) clz.getField(statesKey).get(clz);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		try {
			statusValue = ReflectUtil.getValue(statusKey, value);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return super.doStartTag();
	}

	@Override
	public int doEndTag() throws JspException {
		JspWriter out = pageContext.getOut();
		try {
			out.print("<div class='wrapper'><ul class='flow-steps' style='margin-right: 5px; margin-left: 5px;'>");
			String classVal = "null";
			for (int i = 0; i < statesValue.length; i++) {
				if (statusValue.equals(statesValue[i]))
					classVal = "on";
				else
					classVal = "null";
				out.append("<li class='" + classVal + "'><b></b> <a href='#' title='" + statesValue[i] + "'> " + statesValue[i] + " </a> <s></s></li>");
			}
			out.print("</ul></div>");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return super.doEndTag();
	}

}
