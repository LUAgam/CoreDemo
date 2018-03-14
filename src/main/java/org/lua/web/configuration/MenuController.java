/**
 *        (c) 2006 JOVEN
 *
 *        http://www.joven.com.cn
 */

package org.lua.web.configuration;

import org.lua.constant.ResourceFactory;
import org.lua.entity.RoleMenu;
import org.lua.service.configuration.RoleMenuService;
import org.lua.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;


/**
 * 
 *
 * @author $Author: JHuang $
 * @version $Revision: 4306 $ $Date: 2014-05-08 18:22:19 +0800 (星期四, 08 五月 2014)
 *          $
 */
@Controller
@SessionAttributes(value = { "currentMenuItem", "currentMenuParent" })
@RequestMapping(value = "/menu")
public class MenuController extends BaseController {

	@Autowired
    RoleMenuService roleMenuService;

	@RequestMapping(value = "/{roleMenuId}", method = RequestMethod.GET)
	public String do_redirect(@PathVariable("roleMenuId") String roleMenuId, Model model) {
		RoleMenu roleMenu = roleMenuService.findOne(Long.parseLong(roleMenuId));
		model.addAttribute("currentMenuItem", roleMenu.getDisplayName());
		model.addAttribute("currentMenuParent", roleMenu.getParentRoleMenu() != null ? roleMenu.getParentRoleMenu().getDisplayName() : "");
		return "forward:" + ResourceFactory.getInstance().getURLByName(roleMenu.getName());
	}

}
