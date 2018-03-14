/**
 * 
 */
package org.lua.security;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.lua.entity.Role;
import org.lua.entity.User;
import org.lua.service.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * @author onkyo
 *
 */
public class ShiroDbRealm extends AuthorizingRealm {
	

	
	 	@Autowired
		AccountService accountService;

	    public AccountService getAccountService() {
			return accountService;
		}

		public void setAccountService(AccountService accountService) {
			this.accountService = accountService;
		}

		/* 
		 * 登录判断
		 * (non-Javadoc)
		 * @see org.apache.shiro.realm.AuthorizingRealm#doGetAuthorizationInfo(org.apache.shiro.subject.PrincipalCollection)
		 */
		protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
	    	SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
	        //获取当前登录的用户名
	    	User user = accountService.getCurrentUser();
	    	
	        List<String> roles = new ArrayList<String>();  
	        Set<String> permissions = new HashSet<String>();
	        
	        if(user != null){
	        	List<Role> roleList = accountService.getRoleListByUser(user);
	        	for (Role role : roleList) {
	        		roles.add(role.getName());
	                List<String> permissionList = accountService.getPermissionListByRole(role);
	                permissions.addAll(permissionList);
	        		
	        		//将menu的number作为permission加入到改用户的权限中去，一遍controller可以判断
	                permissions.addAll(accountService.getMenuPermissionSetByRole(role.getId()));
	            }
	        	
	        	
	        }else{
	            throw new AuthorizationException();
	        }
	        //给当前用户设置角色
	        info.addRoles(roles);
	        //给当前用户设置权限
	        info.addStringPermissions(permissions); 
	        return info;
	    }

	    /**
	     *  认证回调函数,登录时调用.
	     */
	    protected AuthenticationInfo doGetAuthenticationInfo(
	            AuthenticationToken authcToken) throws AuthenticationException {
	        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
	        User user = accountService.findUserByUsername(token.getUsername());
	        
	        if (user != null) {
	        	if (user.getPerson() == null) {
		        	throw new RuntimeException("用户[" + user.getUsername() + "]没有配置人员！");
		        }
	        	
	        	return new SimpleAuthenticationInfo(token.getPrincipal(), user.getPassword(), ByteSource.Util.bytes(user.getSalt()),  user.getPerson().getName());
	        } 
	        return null;
	    }
	
}
