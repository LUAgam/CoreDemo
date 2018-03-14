/**
 *        (c) 2010 SDGroup
 *
 *        http://www.sdgroup.com
 */

package org.lua.web.chart.formbeans;


/**
 *
 * @author    $Author: XLShu$
 * @version   $Revision: 2015$ $Date: 2015-2-27下午4:33:01$
 *
 */

public class Piebar {

	//标题
    private String name;
    //保留几位小数
    private Integer formMat;
    
    private PiebarItem[] items;
    
    public Integer getFormMat() {
		return formMat;
	}

	public void setFormMat(Integer formMat) {
		this.formMat = formMat;
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PiebarItem[] getItems() {
        return items;
    }

    public void setItems(PiebarItem[] items) {
        this.items = items;
    }
}

