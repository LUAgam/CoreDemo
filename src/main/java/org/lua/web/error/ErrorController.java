/**
 *        (c) 2009 GoSurf
 *
 *        http://www.gosurf.org
 */

package org.lua.web.error;

import org.lua.web.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * 
 *
 * @author       $Author$
 * @version      $Revision$ $Date$
 */
@Controller
@RequestMapping(value = "/error")
public class ErrorController  extends BaseController {
	
	@RequestMapping(value="/500", method= RequestMethod.GET)
	public String do_500(ModelMap map) {
		return "error/500";
	}
	
	public String do_404() {
		return "error/404";
	}

}
