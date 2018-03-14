/**
 * 
 */
package org.lua.tag;

import java.text.NumberFormat;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

/** 
* @author AMGuo E-mail:www.guoao@foxmail.com 
* @version 创建时间：2017年3月30日 下午5:23:30 
* 类说明 
*/
/**
 * @author LUA
 *
 */
public class EntityOverview extends BaseTag {

	/**
	 * 
	 */
	private static final long serialVersionUID = 799118938177565407L;

	// table允许的列数
	private int column;

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	@Override
	public int doEndTag() throws JspException {
		// 设置宽度比率
		// 创建一个数值格式化对象
		NumberFormat numberFormat = NumberFormat.getInstance();
		numberFormat.setMaximumFractionDigits(5);
		double width = 1.0000 / column;
		String widthString = numberFormat.format(width * 100);
		// 最后一行空白的单元格数
		int colspan = 1;
		JspWriter out = pageContext.getOut();
		int sum = 0;
		try {
			out.print("<div class='widget "+color+"'><div class='widget-title'><h4><i class=''></i>"+title+"</h4><span class='tools'><a href='javascript:;' class='icon-chevron-down'></a><a href='javascript:;' class='icon-remove'></a></span></div><div class='widget-body'><div class='tab-content'><div class='dataTables_wrapper form-inline' role='grid'>");
			out.print("<table class='table table-hover table-bordered dataTable'>");
			int i = 1;
			for (ShowItem showItem : showItemList) {
				if (sum % column == 0)
					out.print("<tr>");
				sum += 1 + showItem.getColspan();
				out.print("<th style='width:" + widthString + "%;'>" + showItem.getTitle() + "</th>");
				// 最后的属性若后面有单元格空余，则合并
				if (i == showItemList.size())
					colspan = column - num * 2 % column + 1;
				out.print("<td style='width:" + widthString + "%;' colspan='" + colspan + "'>" + showItem.getValue() + "</td>");
				if (sum % column == 0)
					out.print("</tr>");
				i++;
			}
			out.print("</table>");
			out.print("</div></div></div></div>");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return super.doStartTag();
	}

}
