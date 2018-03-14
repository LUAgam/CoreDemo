/**
 *        (c) 2006 JOVEN
 *
 *        http://www.joven.com.cn
 */

package org.lua.web.configuration.formbean;

import org.hibernate.validator.constraints.NotEmpty;

import org.lua.web.BaseFormBean;

/**
 * 
 * 
 * @author $Author: JHuang $
 * @version $Revision: 4277 $ $Date: 2014-04-27 16:12:43 +0800 (星期日, 27 四月 2014) $
 */

public class RoleFB extends BaseFormBean {
	
    @NotEmpty(message="角色编号不能为空！")
    private String number;
    
    
    private String description;

    @NotEmpty(message="角色名称不能为空！")
    private String name;

    private boolean checked;
    
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

}
