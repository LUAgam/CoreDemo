/**
 * 
 */
/**
 * (c) 2006 JOVEN
 * 
 * http://www.joven.com.cn
 */


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.lua.constant.Constant;
import org.lua.entity.Person;
import org.lua.entity.Role;
import org.lua.entity.User;
import org.lua.entity.UserRole;
import org.lua.repository.*;
import org.lua.service.configuration.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 测试数据准备
 * @author onkyo
 *
 */
@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations = {"classpath*:applicationContext.xml", "classpath*:activiti.cfg.xml"})
public class RepositorySuiteDBBuilder {
	
	@Autowired
	UserService userService;
	@Autowired
	UserDao userDao;
	
	@Autowired
	PersonDao personDao;
	
	@Autowired
	RoleDao roleDao;
	
	
	@Autowired
	RolePermissionDao rolePermissionDao;
	
	@Autowired
	UserRoleDao userRoleDao;

    
    @Before
    public void deleteDB() {
    	rolePermissionDao.deleteAll();
    	userRoleDao.deleteAll();
    	roleDao.deleteAll();
    	userDao.deleteAll();
    	personDao.deleteAll();
    	
    }
    
    @Test
    public void createUserAndPerson() {
    	
    	Role role = new Role();
    	role.setName("系统管理员");
    	role.setNumber("00001");
    	
    	roleDao.save(role);
    	
    	//Person
    	Person person = new Person();
    	person.setNumber("000000");
    	person.setName("系统管理员");
    	person.setDimission(false);
    	person.setGender(Constant.MALE);
    	person = personDao.save(person);
    	
    	//User user
    	User user = new User();
    	user.setUsername("admin");
    	user.setPassword("111111");
    	user.setComment("系统管理员");
    	user.setLoginAllowed(true);
    	user.setPerson(person);
 
    	userService.saveUser(user);

    	
    	UserRole userRole = new UserRole();
    	userRole.setAccount(user);
    	userRole.setRole(role);
    	userRoleDao.save(userRole);
    	
    	
    	
    }
    
    //@Test
    /*public void createData() {
    	
    	Role role = new Role();
    	role.setName("系统管理员");
    	role.setNumber("00001");
    	
    	roleDao.save(role);
    	
    	//Person
    	Person person = new Person();
    	person.setName("系统管理员");
    	person.setNumber("000001");
    	personDao.save(person);
    	
    	//User user
    	User user = new User();
    	user.setUsername("admin");
    	user.setPassword(StringUtils.md5("111111"));
    	user.setComment("系统管理员");
    	user.setPerson(person);
    	userDao.save(user);
    	
    	UserRole userRole = new UserRole();
    	userRole.setAccount(user);
    	userRole.setRole(role);
    	userRoleDao.save(userRole);
    	
    	Permission permission1 = new Permission();
    	permission1.setDescription("跳转到添加角色界面");
    	permission1.setDisplayname("PAGE_JUMP_ROLE_ADD");
    	permission1.setUrl("/role/add");
    	permission1.setName("1");
    	permissionDao.save(permission1);
    	
    	
    	Permission permission2 = new Permission();
    	permission2.setDescription("跳转到添加账号页面");
    	permission2.setDisplayname("PAGE_JUMP_USER_ADD");
    	permission2.setUrl("/user/add");
    	permission2.setName("2");
    	permissionDao.save(permission2);
    	
    	
    	Permission permission3 = new Permission();
    	permission3.setDescription("跳转到添加人员页面");
    	permission3.setDisplayname("PAGE_JUMP_PERSON_ADD");
    	permission3.setUrl("/person/add");
    	permission3.setName("3");
    	permissionDao.save(permission3);
    	
    	
    	Permission permission4 = new Permission();
    	permission4.setDescription("跳转到添加部门页面");
    	permission4.setDisplayname("PAGE_JUMP_DEPARTMENT_ADD");
    	permission4.setUrl("/department/add");
    	permission4.setName("4");
    	permissionDao.save(permission4);
    	
    	Permission permission5 = new Permission();
    	permission5.setDescription("跳转到添加权限页面");
    	permission5.setDisplayname("PAGE_JUMP_PERMISSION_ADD");
    	permission5.setUrl("/permission/add");
    	permission5.setName("13");
    	permissionDao.save(permission5);
    	
 
    	
    	Permission permission6 = new Permission();
    	permission6.setDescription("添加或修改账号");
    	permission6.setDisplayname("ADD_OR_UPDATE_USER_SUBMIT");
    	permission6.setUrl("/user/save");
    	permission6.setName("6");
    	permissionDao.save(permission6);
    	
    	
    	Permission permission7 = new Permission();
    	permission7.setDescription("添加或修改人员");
    	permission7.setDisplayname("ADD_OR_UPDATE_PERSON_SUBMIT");
    	permission7.setUrl("/person/save");
    	permission7.setName("7");
    	permissionDao.save(permission7);
    	
    	
    	Permission permission8 = new Permission();
    	permission8.setDescription("添加或修改部门");
    	permission8.setDisplayname("ADD_OR_UPDATE_DEPARTMENT_SUBMIT");
    	permission8.setUrl("/department/save");
    	permission8.setName("8");
    	permissionDao.save(permission8);
    	
    	Permission permission9 = new Permission();
    	permission9.setDescription("添加或修改角色");
    	permission9.setDisplayname("ADD_OR_UPDATE_ROLE_SUBMIT");
    	permission9.setUrl("/role/save");
    	permission9.setName("5");
    	permissionDao.save(permission9);
    	
    	Permission permission10 = new Permission();
    	permission10.setDescription("添加或修改权限");
    	permission10.setDisplayname("ADD_OR_UPDATE_PERMISSION_SUBMIT");
    	permission10.setUrl("/permission/save");
    	permission10.setName("20");
    	permissionDao.save(permission10);
    	
    	
    	Permission permission25 = new Permission();
    	permission25.setDescription("用户分配角色提交按钮");
    	permission25.setDisplayname("DISTRIBUTION_PERMISSION_SUBMIT");
    	permission25.setUrl("/user/role");
    	permission25.setName("27");
    	permissionDao.save(permission25);
    	
    	Permission permission26 = new Permission();
    	permission26.setDescription("用户角色修改提交按钮");
    	permission26.setDisplayname("ROLE_PERMISSION_UPDATE_SUBMIT");
    	permission26.setUrl("/role/permission");
    	permission26.setName("28");
    	permissionDao.save(permission26);
    
    	
    	Permission permission11 = new Permission();
    	permission11.setDescription("删除角色");
    	permission11.setDisplayname("DELETE_ROLE_SUBMIT");
    	permission11.setUrl("/role/delete/");
    	permission11.setName("9");
    	permissionDao.save(permission11);
    	
    	
    	Permission permission12 = new Permission();
    	permission12.setDescription("删除账号");
    	permission12.setDisplayname("DELETE_USER_SUBMIT");
    	permission12.setUrl("/user/delete/");
    	permission12.setName("10");
    	permissionDao.save(permission12);
    	
    	
    	Permission permission13 = new Permission();
    	permission13.setDescription("删除人员");
    	permission13.setDisplayname("DELETE_PERSON_SUBMIT");
    	permission13.setUrl("/person/delete/");
    	permission13.setName("11");
    	permissionDao.save(permission13);
    	
    	Permission permission14 = new Permission();
    	permission14.setDescription("删除部门");
    	permission14.setDisplayname("DELETE_DEPARTMENT_SUBMIT");
    	permission14.setUrl("/department/delete/");
    	permission14.setName("12");
    	permissionDao.save(permission14);
    	
    	Permission permission15 = new Permission();
    	permission15.setDescription("删除权限");
    	permission15.setDisplayname("DELETE_PERMISSION_SUBMIT");
    	permission15.setUrl("/permission/delete/");
    	permission15.setName("21");
    	permissionDao.save(permission15);
    	
    	
      	
    	
    	Permission permission16 = new Permission();
    	permission16.setDescription("跳转到角色修改页面");
    	permission16.setDisplayname("PAGE_JUMP_ROLE_UPDATE");
    	permission16.setUrl("/role/edit/");
    	permission16.setName("17");
    	permissionDao.save(permission16);
    	
    	
    	Permission permission17 = new Permission();
    	permission17.setDescription("跳转到账号修改页面");
    	permission17.setDisplayname("PAGE_JUMP_USER_UPDATE");
    	permission17.setUrl("/user/edit/");
    	permission17.setName("18");
    	permissionDao.save(permission17);
    	
    	
    	Permission permission18 = new Permission();
    	permission18.setDescription("跳转到人员修改页面");
    	permission18.setDisplayname("PAGE_JUMP_PERSON_UPDATE");
    	permission18.setUrl("/person/edit/");
    	permission18.setName("19");
    	permissionDao.save(permission18);
    	
    	Permission permission24 = new Permission();
    	permission24.setDescription("跳转到权限修改页面");
    	permission24.setDisplayname("PAGE_JUMP_PERMISSION_UPDATE");
    	permission24.setUrl("/permission/edit/");
    	permission24.setName("14");
    	permissionDao.save(permission24);
    	
    	
    	
    	Permission permission19 = new Permission();
    	permission19.setDescription("分配角色");
    	permission19.setDisplayname("USER_PRIMARY");
    	permission19.setUrl("/user/role/");
    	permission19.setName("22");
    	permissionDao.save(permission19);
    	
    	Permission permission20 = new Permission();
    	permission20.setDescription("重设密码");
    	permission20.setDisplayname("USER_RESET_PASSWORD");
    	permission20.setUrl("/user/resetPassword/");
    	permission20.setName("23");
    	permissionDao.save(permission20);	
    	
    	Permission permission21 = new Permission();
    	permission21.setDescription("用户分配权限");
    	permission21.setDisplayname("DISTRIBUTION_PERMISSION");
    	permission21.setUrl("/role/permission/");
    	permission21.setName("24");
    	permissionDao.save(permission21);
    	
    	Permission permission22 = new Permission();
    	permission22.setDescription("用户分配菜单权限");
    	permission22.setDisplayname("DISTRIBUTION_MENU");
    	permission22.setUrl("/role/menu/");
    	permission22.setName("25");
    	permissionDao.save(permission22);
    	
    	Permission permission23 = new Permission();
    	permission23.setDescription("提交用户菜单权限");
    	permission23.setDisplayname("UPDATE_ROLEMENU_PERMISSION");
    	permission23.setUrl("/role/menu/edit/");
    	permission23.setName("26");
    	permissionDao.save(permission23);
    	
    	
    	*//** 角色权限关系 *//*
    	RolePermission rolePermission1 = new RolePermission();
    	rolePermission1.setRole(role);
    	rolePermission1.setPermission(permission1);
    	rolePermissionDao.save(rolePermission1);
    	
    	RolePermission rolePermission2 = new RolePermission();
    	rolePermission2.setRole(role);
    	rolePermission2.setPermission(permission2);
    	rolePermissionDao.save(rolePermission2);
    	
    	RolePermission rolePermission3 = new RolePermission();
    	rolePermission3.setRole(role);
    	rolePermission3.setPermission(permission3);
    	rolePermissionDao.save(rolePermission3);
    	
    	RolePermission rolePermission4 = new RolePermission();
    	rolePermission4.setRole(role);
    	rolePermission4.setPermission(permission4);
    	rolePermissionDao.save(rolePermission4);
    	
    	RolePermission rolePermission5 = new RolePermission();
    	rolePermission5.setRole(role);
    	rolePermission5.setPermission(permission9);
    	rolePermissionDao.save(rolePermission5);
    	
    	RolePermission rolePermission6 = new RolePermission();
    	rolePermission6.setRole(role);
    	rolePermission6.setPermission(permission6);
    	rolePermissionDao.save(rolePermission6);
    	
    	RolePermission rolePermission7 = new RolePermission();
    	rolePermission7.setRole(role);
    	rolePermission7.setPermission(permission7);
    	rolePermissionDao.save(rolePermission7);
    	
    	RolePermission rolePermission8 = new RolePermission();
    	rolePermission8.setRole(role);
    	rolePermission8.setPermission(permission8);
    	rolePermissionDao.save(rolePermission8);
    	
    	RolePermission rolePermission9 = new RolePermission();
    	rolePermission9.setRole(role);
    	rolePermission9.setPermission(permission11);
    	rolePermissionDao.save(rolePermission9);
    	
    	RolePermission rolePermission10 = new RolePermission();
    	rolePermission10.setRole(role);
    	rolePermission10.setPermission(permission12);
    	rolePermissionDao.save(rolePermission10);
    	
    	RolePermission rolePermission11 = new RolePermission();
    	rolePermission11.setRole(role);
    	rolePermission11.setPermission(permission13);
    	rolePermissionDao.save(rolePermission11);
    	
    	RolePermission rolePermission12 = new RolePermission();
    	rolePermission12.setRole(role);
    	rolePermission12.setPermission(permission14);
    	rolePermissionDao.save(rolePermission12);
    	
    	RolePermission rolePermission13 = new RolePermission();
    	rolePermission13.setRole(role);
    	rolePermission13.setPermission(permission5);
    	rolePermissionDao.save(rolePermission13);
    	
    	RolePermission rolePermission14 = new RolePermission();
    	rolePermission14.setRole(role);
    	rolePermission14.setPermission(permission24);
    	rolePermissionDao.save(rolePermission14);
    	
    	RolePermission rolePermission15 = new RolePermission();
    	rolePermission15.setRole(role);
    	rolePermission15.setPermission(permission15);
    	rolePermissionDao.save(rolePermission15);
    	
    	RolePermission rolePermission16 = new RolePermission();
    	rolePermission16.setRole(role);
    	rolePermission16.setPermission(permission16);
    	rolePermissionDao.save(rolePermission16);
    	
    	RolePermission rolePermission17 = new RolePermission();
    	rolePermission17.setRole(role);
    	rolePermission17.setPermission(permission17);
    	rolePermissionDao.save(rolePermission17);
    	
    	RolePermission rolePermission18 = new RolePermission();
    	rolePermission18.setRole(role);
    	rolePermission18.setPermission(permission18);
    	rolePermissionDao.save(rolePermission18);
    	
    	RolePermission rolePermission19 = new RolePermission();
    	rolePermission19.setRole(role);
    	rolePermission19.setPermission(permission10);
    	rolePermissionDao.save(rolePermission19);
    	
    	RolePermission rolePermission20 = new RolePermission();
    	rolePermission20.setRole(role);
    	rolePermission20.setPermission(permission15);
    	rolePermissionDao.save(rolePermission20);
    	
    	RolePermission rolePermission21 = new RolePermission();
    	rolePermission21.setRole(role);
    	rolePermission21.setPermission(permission19);
    	rolePermissionDao.save(rolePermission21);
    	
    	RolePermission rolePermission22 = new RolePermission();
    	rolePermission22.setRole(role);
    	rolePermission22.setPermission(permission20);
    	rolePermissionDao.save(rolePermission22);
    	
    	RolePermission rolePermission23 = new RolePermission();
    	rolePermission23.setRole(role);
    	rolePermission23.setPermission(permission21);
    	rolePermissionDao.save(rolePermission23);
    	
    	RolePermission rolePermission24 = new RolePermission();
    	rolePermission24.setRole(role);
    	rolePermission24.setPermission(permission22);
    	rolePermissionDao.save(rolePermission24);
    	
    	RolePermission rolePermission25 = new RolePermission();
    	rolePermission25.setRole(role);
    	rolePermission25.setPermission(permission23);
    	rolePermissionDao.save(rolePermission25);
    	
    	RolePermission rolePermission26 = new RolePermission();
    	rolePermission26.setRole(role);
    	rolePermission26.setPermission(permission25);
    	rolePermissionDao.save(rolePermission26);
    	
    	RolePermission rolePermission27 = new RolePermission();
    	rolePermission27.setRole(role);
    	rolePermission27.setPermission(permission26);
    	rolePermissionDao.save(rolePermission27);
    	
    	
    	
    	*//** 用户菜单关联 *//*
    	RoleMenu roleMenu1 = new RoleMenu();
    	roleMenu1.setNumber("1");
    	roleMenu1.setRole(role);
    	roleMenuDao.save(roleMenu1);
    	
    	RoleMenu roleMenu2 = new RoleMenu();
    	roleMenu2.setNumber("2");
    	roleMenu2.setRole(role);
    	roleMenuDao.save(roleMenu2);
    	
    	RoleMenu roleMenu3 = new RoleMenu();
    	roleMenu3.setNumber("3");
    	roleMenu3.setRole(role);
    	roleMenuDao.save(roleMenu3);
    	
    	RoleMenu roleMenu4 = new RoleMenu();
    	roleMenu4.setNumber("4");
    	roleMenu4.setRole(role);
    	roleMenuDao.save(roleMenu4);
    	
    	RoleMenu roleMenu5 = new RoleMenu();
    	roleMenu5.setNumber("5");
    	roleMenu5.setRole(role);
    	roleMenuDao.save(roleMenu5);
    	
    	RoleMenu roleMenu6 = new RoleMenu();
    	roleMenu6.setNumber("6");
    	roleMenu6.setRole(role);
    	roleMenuDao.save(roleMenu6);
    	
    	RoleMenu roleMenu7 = new RoleMenu();
    	roleMenu7.setNumber("7");
    	roleMenu7.setRole(role);
    	roleMenuDao.save(roleMenu7);
    	
    	RoleMenu roleMenu8 = new RoleMenu();
    	roleMenu8.setNumber("8");
    	roleMenu8.setRole(role);
    	roleMenuDao.save(roleMenu8);
    	
    	RoleMenu roleMenu9 = new RoleMenu();
    	roleMenu9.setNumber("9");
    	roleMenu9.setRole(role);
    	roleMenuDao.save(roleMenu9);
    	
    	RoleMenu roleMenu10 = new RoleMenu();
    	roleMenu10.setNumber("10");
    	roleMenu10.setRole(role);
    	roleMenuDao.save(roleMenu10);
    	
    	RoleMenu roleMenu11 = new RoleMenu();
    	roleMenu11.setNumber("11");
    	roleMenu11.setRole(role);
    	roleMenuDao.save(roleMenu11);
    	
    	RoleMenu roleMenu12 = new RoleMenu();
    	roleMenu12.setNumber("12");
    	roleMenu12.setRole(role);
    	roleMenuDao.save(roleMenu12);
    	
    	RoleMenu roleMenu13 = new RoleMenu();
    	roleMenu13.setNumber("13");
    	roleMenu13.setRole(role);
    	roleMenuDao.save(roleMenu13);
    	
    	RoleMenu roleMenu14 = new RoleMenu();
    	roleMenu14.setNumber("14");
    	roleMenu14.setRole(role);
    	roleMenuDao.save(roleMenu14);
    	
    	RoleMenu roleMenu15 = new RoleMenu();
    	roleMenu15.setNumber("15");
    	roleMenu15.setRole(role);
    	roleMenuDao.save(roleMenu15);
    }
*/
}
