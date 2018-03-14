/**
 *        (c) 2006 Joven 
 *
 *        http://www.joven.com.cn
 *        版权所有 2006 上海悦闻信息技术有限公司
 */

package org.lua.web.dialog;

import org.lua.constant.Constant;
import org.lua.service.configuration.UserService;
import org.lua.web.BaseController;
import org.lua.web.PageParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * 类功能描述注释
 *
 * @author       $Author$
 * @version      $Revision$ $Date$
 */
@Controller
@RequestMapping(value = "/dialog/user")
public class UserDialogController extends BaseController {

	/*--------------------------------------------
	 |             C O N S T A N T S    常量       |
	 ============================================*/
	/** Private class log instance. */
	private final static Logger logger = LoggerFactory.getLogger(UserDialogController.class);
	
	@Autowired
    UserService userService;
	
	@RequestMapping(value="/list", method= RequestMethod.GET)
	public String get(HttpServletRequest request, Model model) {
		logger.info("读取数据库中所有的本人的待办的数目，和最新的十条待办。");
		PageParam pp = readPageRequest(request);
		
		PageRequest pageRequest = new PageRequest(pp.getPageNumber(), pp.getPageSize(), new Sort(Sort.Direction.DESC, Constant.DEFAULT_SORT_KEY));
		
		model.addAttribute("userList", userService.getPage(pageRequest));
		
		return "dialog/user/list";
	}
	
	/**
	 * 列表搜索，分页或导出excel
	 */
	@RequestMapping(value="/list", method= RequestMethod.POST)
	public String post(HttpServletRequest request, Model model) {
		//得到整个请求的参数
		PageParam pp = readPageRequest(request);
		
		//设置数据和分页信息
		PageRequest pageRequest = new PageRequest(pp.getPageNumber(), pp.getPageSize(), new Sort(Sort.Direction.DESC, Constant.DEFAULT_SORT_KEY));
		model.addAttribute("userList", userService.getPage(builderSearchString(pp.getSearchParamter().keySet()), pp.getSearchParamter().values().toArray(), pageRequest));
		
		//回写搜索参数
		writePageRequest(model, pp);
		
		return "dialog/user/list";
	}
	
	
}
