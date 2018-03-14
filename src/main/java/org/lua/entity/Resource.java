/**
 * 
 */
package org.lua.entity;

/**
 * @author onkyo
 *
 */
public class Resource {
	
	private String url;
	private String type;
	private String name;
	private String displayName;
	
	public Resource(String url, String type, String name, String displayName) {
		super();
		this.url = url;
		this.type = type;
		this.name = name;
		this.displayName = displayName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

}
