package org.lua.service.configuration;

import com.schickit.utils.StringUtils;
import org.lua.entity.Department;
import org.lua.entity.Person;
import org.lua.repository.DepartmentDao;
import org.lua.repository.PersonDao;
import org.lua.web.configuration.formbean.DepartmentFB;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional(readOnly = true)
public class DepartmentService {

    @Autowired
    DepartmentDao departmentDao;

    @Autowired
    PersonDao personDao;

    // 根据部门 名称查询
    public Department findByName(String name) {
        return departmentDao.findByName(name);
    }

    public DepartmentDao getDepartmentDao() {
        return departmentDao;
    }

    public void setDepartmentDao(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    public Page<Department> findAll(Pageable pageable) {
        return departmentDao.findAll(pageable);
    }

    public Department findOne(Long id) {
        return departmentDao.findOne(id);
    }

    @Transactional(readOnly = false)
    public void save(Department department) {
        departmentDao.save(department);
    }

    @Transactional(readOnly = false)
    public void delete(Long departmentId) {
        departmentDao.delete(departmentId);
    }

    public Page<Department> findAll(Specification<Department> specification, Pageable pageable) {
        return departmentDao.findAll(specification, pageable);
    }

    public Page<Department> getPage(Pageable pageable) {
        return departmentDao.findAll(pageable);
    }

    public Page<Department> getPage(String where, Object[] queryParams, Pageable pageable) {
        return departmentDao.findPage(where, queryParams, pageable);
    }

    public Page<Department> getPage(String sql, String where, Object[] queryParams, Pageable pageable) {
        if (!StringUtils.isEmpty(sql) && !StringUtils.isEmpty(where)) {
            sql += " AND ";
        }
        return departmentDao.findPage(sql + where, queryParams, pageable);
    }

    public List<Department> findParent() {
        return departmentDao.findParent();
    }

    public List<Department> findChild() {
        return departmentDao.findChild();
    }

    public List<Department> findByParentId(Long id) {
        return departmentDao.findByParentId(id);
    }

    public Department getDepartment(Long departmentId) {
        return departmentDao.findOne(departmentId);
    }

    /**
     * 直接返回改用户人员的部门，不做类型的识别
     *
     * @return
     */
    public Department findDepartmentByUser(Long userId) {
        List<Person> pList = personDao.findByUserId(userId);
        Department ret = null;
        if (pList != null && pList.size() > 0) {
            if (pList.get(0).getDepartment() != null) {
                ret = departmentDao.findOne(pList.get(0).getDepartment().getId());

            }
        }
        return ret;
    }

    /**
     * 得到所有的部门
     *
     * @return
     */
    public List<Department> findAll() {
        return departmentDao.findAll();
    }

    /**
     * 转换department为departmentFB
     *
     * @param department
     * @return
     */
    public DepartmentFB toFB(Department department) {
        DepartmentFB fb = new DepartmentFB();
        BeanUtils.copyProperties( department,fb);
        if (department.getParentDepartment() != null) {
            fb.setParentId(department.getParentDepartment().getId());
            fb.setParentName(department.getParentDepartment().getName());
        }

        return fb;
    }

}
