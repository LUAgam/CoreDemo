/**
 *        (c) 2010 SDGroup
 *
 *        http://www.sdgroup.com
 */

package org.lua.web.configuration.formbean;

import org.hibernate.validator.constraints.NotEmpty;

import org.lua.web.BaseFormBean;

/**
 * 
 * @author $Author: XLShu$
 * @version $Revision: 4277 $Date: 2014-1-9下午1:53:40$
 * 
 */

public class TenantFB extends BaseFormBean {
    @NotEmpty(message = "编号不能为空")
    private String number;

    @NotEmpty(message = "名称不能为空")
    private String name;

    private String description;

    private int version;

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

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

}
