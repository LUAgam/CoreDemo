/**
 *        (c) 2010 SDGroup
 *
 *        http://www.sdgroup.com
 */

package org.lua.service.configuration;

import org.lua.entity.Tenant;
import org.lua.repository.TenantDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


/**
 * 域 service
 * @author    $Author: XLShu$
 * @version   $Revision: 4306 $Date: 2014-1-9上午10:46:54$
 *
 */
@Component
@Transactional(readOnly = true)
public class TenantService {
    @Autowired
    private TenantDao tenantDao;

    public TenantDao getTenantDao() {
        return tenantDao;
    }

    public void setTenantDao(TenantDao tenantDao) {
        this.tenantDao = tenantDao;
    }
    
    public Tenant findOne(Long tenantId) {
        return this.tenantDao.findOne(tenantId);
    }
    
    public Page<Tenant> findAll(Pageable pageable) {
        return this.tenantDao.findAll(pageable);
    }
    
    @Transactional(readOnly = false)
    public void saveTenant(Tenant entity) {
        tenantDao.save(entity);
    }
    
    @Transactional(readOnly = false)
    public void remove(Long id) {
        tenantDao.delete(id);
    }
}

