package org.lua.web.configuration.formbean;

import org.hibernate.validator.constraints.NotEmpty;
import org.lua.entity.User;
import org.lua.web.BaseFormBean;
import org.springframework.beans.BeanUtils;


public class UserFB extends BaseFormBean {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2918340121325043840L;

	@NotEmpty(message="用户名不能为空！")
	private String username;

    private String password;
	
	private String newPassword;

    private boolean loginAllowed = true;
     
    private String comment;
    
    private String personName;
    
    private Long personId;
    
    private Long deptId;
    private String deptName;
    
    private int version;

    private Boolean isSelect;
    
	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean getLoginAllowed() {
		return loginAllowed;
	}

	public void setLoginAllowed(boolean loginAllowed) {
		this.loginAllowed = loginAllowed;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	
	public Boolean getIsSelect() {
		return isSelect;
	}

	public void setIsSelect(Boolean isSelect) {
		this.isSelect = isSelect;
	}

	public static UserFB toFB(User user) {
	    UserFB userFB = new UserFB();
	    BeanUtils.copyProperties(user,userFB);
	    if (user.getPerson() != null) {
	        userFB.setPersonId(user.getPerson().getId());
	        userFB.setPersonName(user.getPerson().getName());
	        if (user.getPerson().getDepartment() != null) {
	        	userFB.setDeptId(user.getPerson().getDepartment().getId());
	        	userFB.setDeptName(user.getPerson().getDepartment().getName());
	        }
	    }
	    return userFB;
	}

}
