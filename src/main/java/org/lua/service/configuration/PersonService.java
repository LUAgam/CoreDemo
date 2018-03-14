package org.lua.service.configuration;

import org.lua.entity.Person;
import org.lua.repository.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional(readOnly = true)
public class PersonService {
	
	@Autowired
    PersonDao personDao;


	public Person findOne(Long personId) {
		return this.personDao.findOne(personId);
	}
	
	public Page<Person> findAll(Pageable pageable) {
		return this.personDao.findAll(pageable);
	}
	
	public Page<Person> findAll(Specification<Person> specification, Pageable pageable) {
		return this.personDao.findAll(specification, pageable);
	}
	
	@Transactional(readOnly = false)
	public void savePerson(Person entity) {
		personDao.save(entity);
	}
	@Transactional(readOnly = false)
	public void remove(Long personId) {
		personDao.delete(personId);
	}

	public List<Person> findAll() {
		return personDao.findAll();
	}
	
	public Person findByNumber(String number) {
	    return personDao.findByNumber(number);
	}
	
	public Page<Person> getPage(Pageable pageable) {
		return personDao.findAll(pageable);
	}
	
	public Page<Person> getPage(String where, Object[] queryParams, Pageable pageable) {
		return personDao.findPage(where, queryParams, pageable);
	}
	
	public List<Person> findAll(String hql, Object[] queryParams) {
		return personDao.findAll(hql, queryParams);
	}
	
	public List<Person> findAllByDepartment(Long departmentId) {
		return personDao.findByDepartmentId(departmentId);
	}
}
