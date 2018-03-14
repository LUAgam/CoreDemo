package org.lua.web.account;

import com.schickit.utils.StringUtils;
import org.lua.service.configuration.UserService;
import org.lua.util.ErrorUtils;
import org.lua.web.account.formbean.UserChangePasswordFB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * 忘记密码
 * @author    $Author: XLShu$
 * @version   $Revision: 4277 $Date: 2014-3-21下午2:27:06$
 *
 */
@Controller
@RequestMapping(value = "/forget")
public class ForgetController {
    
    @Autowired
    UserService userService;
    
    
    /**
     * 忘记密码
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String do_changePassword() {
        return "account/forget";
    }
    
    /**
     * 修改密码
     * @param result
     * @param map
     * @return
     * @throws Exception 
     */
    @RequestMapping(method = RequestMethod.POST)
    public String do_changePassword(@ModelAttribute @Valid UserChangePasswordFB userFB,
            BindingResult result,
            ModelMap map) throws Exception {
        
        if(result.hasErrors()){  
            map.addAttribute("message", ErrorUtils.fetchAllErrorMessages(result));
            map.addAttribute("user", userFB);
            return "account/forget";
        }
        
        String errorMessage = userService.sendNewPassword(userFB.getUserName(), userFB.getEmail());
        if (false == StringUtils.isEmpty(errorMessage)) {
            map.addAttribute("message", errorMessage);
            map.addAttribute("user", userFB);
            return "account/forget";
        }
        return "account/login";
    }
}

