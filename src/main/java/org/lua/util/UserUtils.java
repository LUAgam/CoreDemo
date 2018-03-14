package org.lua.util;

import com.schickit.utils.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.lua.constant.Constant;
import org.lua.entity.Department;
import org.lua.entity.Menu;
import org.lua.entity.Person;
import org.lua.entity.User;

import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA. User: kady Date: 13-6-26 Time: 上午11:04 To change
 * this template use File | Settings | File Templates.
 */
public final class UserUtils {

	private UserUtils() {
	}
	
	
	public static void setValue(String key, Object value) {
		Subject currentUser = SecurityUtils.getSubject();
		if (null != currentUser) {
			Session session = currentUser.getSession();
			if (null != session) {
				session.setAttribute(key, value);
			}
		}
	}
	
	public static Object getValue(String key) {
		Subject currentUser = SecurityUtils.getSubject();
        if (null != currentUser) {
            Session session = currentUser.getSession();
            if (null != session) {
                return session.getAttribute(key);
            }
        }
        return null;
	}

	public static User getCurrentUser(){
    	Subject currentUser = SecurityUtils.getSubject();
        if (null != currentUser) {
            Session session = currentUser.getSession();
            if (null != session) {
                User user = (User) session.getAttribute(Constant.SESSION_USER);
                if(null != user){
                    return user;
                }
            }
        }
        //TODO throw new Failed Auth Exception
        return null;
    }

	public static void setCurrentUser(User user, Person person, Department department) {
		Subject currentUser = SecurityUtils.getSubject();
		if (null != currentUser) {
			Session session = currentUser.getSession();
			if (null != session) {
				session.setAttribute(Constant.SESSION_USER, user);
				session.setAttribute(Constant.SESSION_PERSON, person);
				session.setAttribute(Constant.SESSION_DEPARTMENT, department);
			}
		}
	};
	
	public static List<Menu> getCurrentUserMenuList() {
		List<Menu> menuList = new LinkedList<Menu>();
		
		Subject currentUser = SecurityUtils.getSubject();
		if (null != currentUser) {
			Session session = currentUser.getSession();
			if (null != session) {
				menuList = (List<Menu>)session.getAttribute(Constant.SESSION_MENU);
			}
		}
		
		return menuList;
	}
	
	public static void setUserMenuList(List<Menu> menuList) {
		Subject currentUser = SecurityUtils.getSubject();
		if (null != currentUser) {
			Session session = currentUser.getSession();
			if (null != session) {
				session.setAttribute(Constant.SESSION_MENU, menuList);
		
			}
		}
	}
	
	public static void checkPermission(String perm) {
		Subject currentUser = SecurityUtils.getSubject();
		currentUser.checkPermission(perm);
	}
	
	public static void checkRole(String role) {
		Subject currentUser = SecurityUtils.getSubject();
		currentUser.checkRole(role);
	}
	
	public static boolean isAdmin() {
		Subject currentUser = SecurityUtils.getSubject();
		if (null != currentUser) {
			Session session = currentUser.getSession();
			if (null != session) {
				Boolean ret = (Boolean) session.getAttribute(Constant.SESSION_ADMIN);
				if (ret != null) {
					return ret;
				}
			}
		}
		return false;
	}
	
	public static void setAdmin(Boolean admin) {
		Subject currentUser = SecurityUtils.getSubject();
		if (null != currentUser) {
			Session session = currentUser.getSession();
			if (null != session) {
				session.setAttribute(Constant.SESSION_ADMIN, admin);
			}
		}
	}
	
	public static void main(String[] args) {
		System.err.println(StringUtils.md5("123456"));
	}

}
