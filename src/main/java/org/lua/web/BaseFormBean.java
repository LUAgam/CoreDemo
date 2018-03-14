/**
 * 
 */
package org.lua.web;

import java.io.Serializable;

/**
 * @author onkyo
 *
 */
public abstract class BaseFormBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3793253329058930L;
	private Long id;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
