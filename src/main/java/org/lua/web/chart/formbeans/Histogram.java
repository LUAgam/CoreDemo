/**
 * 
 */
package org.lua.web.chart.formbeans;

/**
 * @author p.zhou
 *
 */
public class Histogram {

	private String title;
	private String header;
	private String unit;
	private String name;
	private HistogramItem[] items;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public HistogramItem[] getItems() {
		return items;
	}
	public void setItems(HistogramItem[] items) {
		this.items = items;
	}
	
	
	
	
}
