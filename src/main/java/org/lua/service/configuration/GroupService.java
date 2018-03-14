/**
 *
 *     (c) 2006 JOVEN
 *
 *     http://www.joven.com.cn
 *
 */
package org.lua.service.configuration;

import org.lua.entity.Group;
import org.lua.repository.GroupDao;
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
public class GroupService {
	
	@Autowired
    GroupDao groupDao;
	
	/**
     * 根据id查找
     * @param id
     * @return
     */
    public Group findOne(Long id) {
        return groupDao.findOne(id);
    }
	
	/**
     * 不分页，返回所有角色
     * @return
     */
	public List<Group> findAll() {
		return groupDao.findAll();
	}
	
	/**
     * 分页，返回角色
     * @return
     */
	public Page<Group> getPage(Pageable pageable) {
		return groupDao.findAll(pageable);
	}
	
	/**
     * 分页，带条件返回所有角色
     * @return
     */
	public Page<Group> getPage(String where, Object[] queryParams, Pageable pageable) {
		return groupDao.findPage(where, queryParams, pageable);
	}
	
    /**
     * 保存
     * @param entity
     */
    @Transactional(readOnly = false)
    public void save(Group entity) {
        groupDao.save(entity);
    }
    
    /**
     * 删除
     * @param id
     */
    @Transactional(readOnly = false)
    public void remove(Long id) {
        groupDao.delete(id);
    }
	

}