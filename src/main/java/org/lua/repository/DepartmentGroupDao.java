package org.lua.repository;

import org.lua.entity.Department;
import org.lua.entity.DepartmentGroup;
import org.lua.entity.Group;
import org.lua.repository.base.BaseRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
/**
 * 
 * @author ZZWang
 * @Time 2017年3月31日  上午9:56:33
 *
 */
public interface DepartmentGroupDao extends BaseRepository<DepartmentGroup, Long>,JpaSpecificationExecutor<DepartmentGroup> {
	
	@Query("select entity.group from DepartmentGroup entity where  entity.dep.id=?")
	public List<Group> findGroupByDepartment(Long id);
	
	@Query("select entity.dep from DepartmentGroup entity where  entity.group.id=?")
	public List<Department> findDepByGroup(Long id);
	
	@Query("select entity.dep.no from DepartmentGroup entity where  entity.group.id=?")
	public List<String> findDepNoByGroup(Long id);
	
	@Query("select entity.group.name from DepartmentGroup entity where  entity.dep.id=?")
	public List<String> findGroupNameByDepartment(Long id);
	
	@Modifying
	@Query("delete  from DepartmentGroup entity where  entity.group.id=?")
	public void deleteByGroup(Long groupId);
	
	@Modifying
	@Query("delete  from DepartmentGroup entity where  entity.dep.id=?")
	public void deleteByDepartment(Long depId);
	
}
