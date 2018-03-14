/**
 *        (c) 2010 SDGroup
 *
 *        http://www.sdgroup.com
 */

package org.lua.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

/**
 * 域
 * 
 * @author $Author: XLShu$
 * @version $Revision: 4277 $Date: 2014-1-9上午10:16:56$
 * 
 */
@Entity
@Table(name = "tbl_tenant", uniqueConstraints = { @UniqueConstraint(columnNames = "number") })
public class Tenant extends BaseEntity<Tenant> {

    /**
     * 
     */
    private static final long serialVersionUID = -8086056756295537326L;

    /**
     * 编号
     */
    @NotNull
    private String number;

    /**
     * 名称
     */
    @NotNull
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * version
     */
    @Version
    private int version;

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

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

}
