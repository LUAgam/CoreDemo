/**
 *        (c) 2006 JOVEN
 *
 *        http://www.joven.com.cn
 */

package org.lua.service.configuration;

import org.apache.commons.lang3.StringUtils;
import org.lua.entity.Department;
import org.lua.entity.DepartmentGroup;
import org.lua.entity.Group;
import org.lua.repository.DepartmentGroupDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author ZZWang
 * @Time 2017年3月30日  下午2:17:38
 *
 */
@Component
@Transactional(readOnly = true)
public class DepartmentGroupService {
	
    final Logger logger = LoggerFactory.getLogger(DepartmentGroupService.class);
    
	@Autowired
	private DepartmentGroupDao dgDao;
	
	public DepartmentGroup findOne(Long id) {
		return this.dgDao.findOne(id);
	}
	
	public Page<DepartmentGroup> findAll(Pageable pageable) {
		return this.dgDao.findAll(pageable);
	}
	
	public Page<DepartmentGroup> findAll(Specification<DepartmentGroup> specification, Pageable pageable) {
		return this.dgDao.findAll(specification, pageable);
	}
	
	public List<DepartmentGroup> findAll(Specification<DepartmentGroup> specification,Sort sort) {
	    return dgDao.findAll(specification, sort);
	}
	
	@Transactional(readOnly = false)
	public void save(DepartmentGroup entity) {
		dgDao.save(entity);
	}
	
	@Transactional(readOnly = false)
	public void remove(Long id) {
		dgDao.delete(id);
	}
	
	public Page<DepartmentGroup> getPage(Pageable pageable) {
		return dgDao.findAll(pageable);
	}
	
	public Page<DepartmentGroup> getPage(String where, Object[] queryParams, Pageable pageable) {
		return dgDao.findPage(where, queryParams, pageable);
	}
	
	/**
	 * 根据部门查找岗位(不分页)
	 * @param depId
	 * @return
	 */
	public List<Group> findGroupByDepartment(Long depId){
		return dgDao.findGroupByDepartment(depId);
	}
	
	/**
	 * 查找部门下所有岗位名称
	 * @param depId
	 * @return
	 */
	public List<String> findGroupNameByDepartment(Long depId){
		return dgDao.findGroupNameByDepartment(depId);
	}
	
	/**
	 * 根据部门查找岗位(分页)
	 * @param depId
	 * @param where
	 * @param queryParams
	 * @param pageable
	 * @return
	 */
	public Page<DepartmentGroup> findByDepartment(Long depId,String where, Object[] queryParams, Pageable pageable){
		if(StringUtils.isBlank(where)){
			where=" entity.dep.id=?";
		}
		else 
			where+=" and entity.dep.id=?";
		List<Object> paramList = new ArrayList<Object>(Arrays.asList(queryParams));
		paramList.add(depId);
		return dgDao.findPage(where, paramList.toArray(), pageable);
	}
	
	/**
	 * 查询岗位下的所有部门(不分页)
	 * @param groupId
	 * @return
	 */
	public List<Department> findByGroup(Long groupId){
		return dgDao.findDepByGroup(groupId);
	}
	
	/**
	 * 查询岗位下的所有部门名称(不分页)
	 * @param groupId
	 * @return
	 */
	public List<String> findDepNoByGroup(Long groupId){
		return dgDao.findDepNoByGroup(groupId);
	}
	

	/**
	 * 删除岗位下的所有部门
	 * @param groupId
	 */
	@Transactional(readOnly=false)
	public void deleteByGroup(Long groupId){
		dgDao.deleteByGroup(groupId);
	}
	
	/**
	 * 删除部门下的所有岗位
	 */
	@Transactional(readOnly=false)
	public void deleteByDepartment(Long depId){
		dgDao.deleteByDepartment(depId);
	}
}
