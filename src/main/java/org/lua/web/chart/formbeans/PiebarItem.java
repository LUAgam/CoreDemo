/**
 *        (c) 2010 SDGroup
 *
 *        http://www.sdgroup.com
 */

package org.lua.web.chart.formbeans;

/**
 * 
 * @author $Author: XLShu$
 * @version $Revision: 2015$ $Date: 2015-2-27下午4:34:52$
 * 
 */

public class PiebarItem {

    private String name;
    private Double value;
    private String color;

    public PiebarItem(String name, Double value) {
        super();
        this.name = name;
        this.value = value;
    }

    public PiebarItem(String name, Double value, String color) {
        super();
        this.name = name;
        this.value = value;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
