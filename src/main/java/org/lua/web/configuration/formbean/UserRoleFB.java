/**
 *        (c) 2010 SDGroup
 *
 *        http://www.sdgroup.com
 */

package org.lua.web.configuration.formbean;

import org.lua.web.BaseFormBean;

/**
 * 
 * @author $Author: XLShu$
 * @version $Revision: 4306 $Date: 2014-1-9下午4:03:09$
 * 
 */

public class UserRoleFB extends BaseFormBean {

    private Long userId;

    private String[] selectrole;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String[] getSelectrole() {
		return selectrole;
	}

	public void setSelectrole(String[] selectrole) {
		this.selectrole = selectrole;
	}
}
