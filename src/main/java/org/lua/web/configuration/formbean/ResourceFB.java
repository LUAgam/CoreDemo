package org.lua.web.configuration.formbean;

import org.lua.web.BaseFormBean;

/**
 * 
 * @author ZZWang
 * @Time 2017年3月24日 上午10:48:31
 *
 */
public class ResourceFB extends BaseFormBean {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6414664465918613204L;
	
	private String url;
	private String type;
	private String name;
	private String displayName;
	private Boolean selected;
	
	public String getUrl() {
		return url;
	}

	public String getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public Boolean getSelected() {
		return selected;
	}

	public void setSelected(Boolean selected) {
		this.selected = selected;
	}

}
