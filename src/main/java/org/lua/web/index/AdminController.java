/**
 *        (c) 2006 JOVEN
 *
 *        http://www.joven.com.cn
 */

package org.lua.web.index;

import org.lua.entity.Person;
import org.lua.util.UserUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


/**
 * 
 *
 * @author       $Author: JHuang $
 * @version      $Revision: 4277 $ $Date: 2014-04-27 16:12:43 +0800 (星期日, 27 四月 2014) $
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String admin(RedirectAttributes redirectAttributes) {
		
		Person person = UserUtils.getCurrentUser().getPerson();
	
		return "redirect:/admin/profile/portal";
	}
	
}
