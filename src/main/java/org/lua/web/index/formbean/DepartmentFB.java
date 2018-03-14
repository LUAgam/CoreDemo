/**
 * 
 */
package org.lua.web.index.formbean;

import org.lua.entity.Person;
import org.lua.web.BaseFormBean;

import java.util.LinkedList;
import java.util.List;

/**
 * @author onkyo
 *
 */
public class DepartmentFB extends BaseFormBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8204908894747316643L;
	
	private String name;

	private String no;
	
	private String description;

	private List<Person> personList = new LinkedList<Person>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Person> getPersonList() {
		return personList;
	}

	public void setPersonList(List<Person> personList) {
		this.personList = personList;
	}

}
