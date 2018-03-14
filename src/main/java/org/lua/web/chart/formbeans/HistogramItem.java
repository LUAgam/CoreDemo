/**
 * 
 */
package org.lua.web.chart.formbeans;

/**
 * @author p.zhou
 *
 */
public class HistogramItem {

	private String name;
	private Double value;
	
	
	public HistogramItem() {
		super();
	}
	public HistogramItem(String name, Double value) {
		super();
		this.name = name;
		this.value = value;
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
	
	
}
