package org.lua.service.configuration;

import org.lua.entity.Role;
import org.lua.repository.RoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional(readOnly = true)
public class RoleService {

    @Autowired
    private RoleDao dao;

    public RoleDao getDao() {
        return dao;
    }

    public void setDao(RoleDao dao) {
        this.dao = dao;
    }

    /**
     * 根据id查找
     * @param id
     * @return
     */
    public Role findOne(Long id) {
        return this.dao.findOne(id);
    }
    
    /**
     * 不分页，返回所有角色
     * @return
     */
    public List<Role> findAll() {
    	return this.dao.findAll();
    }

    /**
     * 查询所有
     * @param pageable
     * @return
     */
    public Page<Role> findAll(Pageable pageable) {
        return this.dao.findAll(pageable);
    }
    
	public Page<Role> findAll(Specification<Role> specification, Pageable pageable) {
		return this.dao.findAll(specification, pageable);
	}
    /**
     * 保存
     * @param entity
     */
    @Transactional(readOnly = false)
    public void saveRole(Role entity) {
        dao.save(entity);
    }
    
    /**
     * 删除
     * @param id
     */
    @Transactional(readOnly = false)
    public void remove(Long id) {
        dao.delete(id);
    }
    
    public Page<Role> getPage(Pageable pageable) {
		return dao.findAll(pageable);
	}

	public Page<Role> getPage(String where, Object[] queryParams, Pageable pageable) {
		return dao.findPage(where, queryParams, pageable);
	}
    
}
