/**
 *        (c) 2010 SDGroup
 *
 *        http://www.sdgroup.com
 */

package org.lua.web.account.formbean;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import org.lua.web.BaseFormBean;

/**
 * 用户修改密码
 * @author    $Author: XLShu$
 * @version   $Revision: 4277 $Date: 2014-3-21下午1:37:33$
 *
 */

public class UserChangePasswordFB extends BaseFormBean {
    
    /**
     * 用户名
     */
    @NotEmpty(message="用户名不能为空！")
    private String userName;
    
    /**
     * 邮件
     */
    @NotEmpty(message="邮箱不能为空！")
    @Email(message="邮箱格式错误！")
    private String email;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}

