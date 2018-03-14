/**
 *        (c) 2006 JOVEN
 *
 *        http://www.joven.com.cn
 */

package org.lua.web.account;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.lua.service.admin.LoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;


/**
 * LogoutController 负责登出页面 (GET请求)
 *
 * @author       $Author: JHuang $
 * @version      $Revision: 4277 $ $Date: 2014-04-27 16:12:43 +0800 (星期日, 27 四月 2014) $
 */
@Controller
@RequestMapping(value = "/logout")
public class LogoutController {
	
	@Autowired
    LoginLogService loginLogService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String do_get(HttpSession session) {
		loginLogService.logout(session.getId());
		Subject currentUser = SecurityUtils.getSubject();
		currentUser.logout();
		return "redirect:/index";
	}

}
