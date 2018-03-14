/**
 * 
 */
package org.lua.web.dialog;

import org.lua.service.configuration.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * @author onkyo
 *
 */
@Controller
@RequestMapping(value = "/dialog/chart")
public class ChartDialogController {
	
	@Autowired
    PersonService personService;
	
	@RequestMapping(value="/test", method= RequestMethod.GET)
	public String portalChart() {

		return "dialog/chart/chart";
	}
	
	@RequestMapping(value="/test1", method= RequestMethod.GET)
	public String portalChart1() {

		return "dialog/chart/chart1";
	}
	
	@RequestMapping(value="/test2", method= RequestMethod.GET)
	public String portalChart2() {

		return "dialog/chart/chart2";
	}
	
}
