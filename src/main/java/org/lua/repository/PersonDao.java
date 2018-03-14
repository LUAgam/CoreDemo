/**
 * (c) 2006 JOVEN
 * 
 * http://www.joven.com.cn
 */
package org.lua.repository;

import org.lua.entity.Person;
import org.lua.repository.base.BaseRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonDao extends BaseRepository<Person, Long>, JpaSpecificationExecutor<Person> {

	@Query("SELECT p FROM User u LEFT JOIN u.person p WHERE u.id=?")
	public List<Person> findByUserId(Long userId);

	public Person findByNumber(String number);
	
	@Query("SELECT p FROM Person p WHERE p.department.id=?")
	public List<Person> findByDepartmentId(Long departmentId);
}