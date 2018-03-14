/**
 *        (c) 2010 Shanghai SDGroup Information GmbH
 *
 *        http://www.sdgroup.com/
 */
package org.lua.repository;

import org.lua.entity.Department;
import org.lua.repository.base.BaseRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 *
 *
 * @author      $JKe$
 * @version      $Revision: 4306 $ 2014-1-9上午10:51:54
 **/
public interface DepartmentDao extends BaseRepository<Department,Long>,JpaSpecificationExecutor<Department> {

	/**
	 * 根据部门名称查找部门
	 * @param name
	 * @return
	 */
	@Query("SELECT d FROM Department d WHERE d.name = ?1")
	Department findByName(String name);

	//查询所有父部门
	@Query("SELECT d FROM Department d WHERE d.parentDepartment is null")
	public List<Department> findParent();

	//查询所有子部门
	@Query("SELECT d FROM Department d WHERE d.parentDepartment is not null")
	public List<Department> findChild();

	//根据父部门 查询子部门
	@Query("SELECT d FROM Department d WHERE d.parentDepartment.id = ?1")
	public List<Department> findByParentId(Long id);

}
