/**
 *        (c) 2010 SDGroup
 *
 *        http://www.sdgroup.com
 */

package org.lua.repository;

import org.lua.entity.Tenant;
import org.lua.repository.base.BaseRepository;

/**
 * 域dao
 * @author    $Author: XLShu$
 * @version   $Revision: 4306 $Date: 2014-1-9上午10:38:02$
 *
 */

public interface TenantDao extends BaseRepository<Tenant, Long> {
    
    public Tenant findByNumber(String number);
    
    public Tenant findByName(String name);
}

