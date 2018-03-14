/**
 *        (c) 2006 JOVEN
 *
 *        http://www.joven.com.cn
 */

package org.lua.service.configuration;

import org.lua.entity.UserGroup;
import org.lua.repository.UserGroupDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 
 * @author ZZWang
 * @Time 2017年3月30日 下午2:17:38
 *
 */
@Component
@Transactional(readOnly = true)
public class UserGroupService {

	final Logger logger = LoggerFactory.getLogger(UserGroupService.class);

	@Autowired
	private UserGroupDao ugDao;

	public UserGroup findOne(Long id) {
		return this.ugDao.findOne(id);
	}

	public Page<UserGroup> findAll(Pageable pageable) {
		return this.ugDao.findAll(pageable);
	}

	public Page<UserGroup> findAll(Specification<UserGroup> specification, Pageable pageable) {
		return this.ugDao.findAll(specification, pageable);
	}

	public List<UserGroup> findAll(Specification<UserGroup> specification, Sort sort) {
		return ugDao.findAll(specification, sort);
	}

	@Transactional(readOnly = false)
	public void save(UserGroup entity) {
		ugDao.save(entity);
	}

	@Transactional(readOnly = false)
	public void remove(Long id) {
		ugDao.delete(id);
	}

	public Page<UserGroup> getPage(Pageable pageable) {
		return ugDao.findAll(pageable);
	}

	public Page<UserGroup> getPage(String where, Object[] queryParams, Pageable pageable) {
		return ugDao.findPage(where, queryParams, pageable);
	}

	/**
	 * 根据部门和岗位找到所有用户的用户名
	 * 
	 * @param groupId
	 * @param depId
	 * @return
	 */
	public List<String> findUsernameByGroupAndDep(Long groupId, Long depId) {
		return ugDao.findUsernameByGroupAndDep(groupId, depId);
	}

	/**
	 * 删除岗位下的一个用户
	 * 
	 * @param userId
	 * @param groupId
	 */
	@Transactional(readOnly = false)
	public void deleteByUserAndGroup(Long userId, Long groupId) {
		ugDao.deleteByUserAndGroup(userId, groupId);
	}

	/**
	 * 找到部门下某个岗位的所有用户
	 * 
	 * @param groupId
	 * @param depId
	 * @return
	 */
	public List<UserGroup> findByGroupAndDep(Long groupId, Long depId) {
		return ugDao.findByGroupAndDep(groupId, depId);
	}

	/**
	 * 找到部门下某个岗位的当班人员用户名
	 * 
	 * @param groupId
	 * @param depId
	 * @return
	 */
	public List<String> findOnWorkUsernameByGroupAndDep(Long groupId, Long depId) {
		return ugDao.findOnWorkUsernameByGroupAndDep(groupId, depId);
	}

	/**
	 * 将某个部门下某个岗位的用户都设置为非当班状态
	 * 
	 * @param groupId
	 * @param depId
	 */
	@Transactional(readOnly = false)
	public void updateOnWork(Long groupId, Long depId) {
		List<UserGroup> userGroupList = ugDao.findByGroupAndDep(groupId, depId);
		if (userGroupList != null) {
			for (UserGroup ug : userGroupList) {
				ug.setIsOnWork(false);
				save(ug);
			}
		}
	}
}
