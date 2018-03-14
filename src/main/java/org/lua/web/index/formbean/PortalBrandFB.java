/**
 * 
 */
package org.lua.web.index.formbean;

import org.lua.web.BaseFormBean;

/**
 * @author WLL
 *
 */
public class PortalBrandFB extends BaseFormBean {

	private String brand;
	
	private Integer zdftNumber;
	private Integer wzadtNumber;
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public Integer getZdftNumber() {
		return zdftNumber;
	}
	public void setZdftNumber(Integer zdftNumber) {
		this.zdftNumber = zdftNumber;
	}
	public Integer getWzadtNumber() {
		return wzadtNumber;
	}
	public void setWzadtNumber(Integer wzadtNumber) {
		this.wzadtNumber = wzadtNumber;
	}
}
