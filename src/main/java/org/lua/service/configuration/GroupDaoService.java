/**
 *
 *     (c) 2006 JOVEN
 *
 *     http://www.joven.com.cn
 *
 */
package org.lua.service.configuration;

import org.lua.entity.UserGroup;
import org.lua.repository.UserGroupDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 *
 */
@Component
@Transactional(readOnly = true)
public class GroupDaoService {
	
	@Autowired
    UserGroupDao userGroupDao;
	
	/**
     * 根据id查找
     * @param id
     * @return
     */
    public UserGroup findOne(Long id) {
        return userGroupDao.findOne(id);
    }
	
	/**
     * 不分页，返回所有角色
     * @return
     */
	public List<UserGroup> findAll() {
		return userGroupDao.findAll();
	}
	
	/**
     * 分页，返回角色
     * @return
     */
	public Page<UserGroup> getPage(Pageable pageable) {
		return userGroupDao.findAll(pageable);
	}
	
	/**
     * 分页，带条件返回所有角色
     * @return
     */
	public Page<UserGroup> getPage(String where, Object[] queryParams, Pageable pageable) {
		return userGroupDao.findPage(where, queryParams, pageable);
	}
	
    /**
     * 保存
     * @param entity
     */
    @Transactional(readOnly = false)
    public void save(UserGroup entity) {
        userGroupDao.save(entity);
    }
    
    /**
     * 删除
     * @param id
     */
    @Transactional(readOnly = false)
    public void remove(Long id) {
        userGroupDao.delete(id);
    }
	

}