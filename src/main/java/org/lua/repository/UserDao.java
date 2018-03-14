package org.lua.repository;

import org.lua.entity.User;
import org.lua.repository.base.BaseRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserDao extends BaseRepository<User, Long>, JpaSpecificationExecutor<User> {
	
	public User findByUsername(String username);
	
	@Query(value="SELECT u.* FROM tbl_user u LEFT JOIN tbl_person p on u.person=p.id LEFT JOIN tbl_department d ON d.id = p.department LEFT JOIN tbl_user_role ur ON ur.account = u.id LEFT JOIN tbl_role_permission rp ON ur.role = rp.role LEFT JOIN tbl_permission per ON rp.permission = per.id WHERE d.id=?1 and per.id=?2 ", nativeQuery=true)
	public List<User> findByDepartmentAndPermission(Long departmentId, Long permissionId);
	
	
	@Query("select entity from User entity where entity.person.department.id=?")
	public List<User> findByDepartment(Long departmentId);
	
	@Query("select entity from User entity where entity.person.id=?")
	public User findByPersonId(Long personId);

}
