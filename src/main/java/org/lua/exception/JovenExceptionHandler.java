/**
 * 
 */
package org.lua.exception;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 统一错误处理
 * @author JHuang
 *
 */
public class JovenExceptionHandler  implements HandlerExceptionResolver {  
  
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,  
            Exception ex) {  
        Map<String, Object> model = new HashMap<String, Object>();  
        model.put("ex", ex);  
          
        // 根据不同错误转向不同页面, 根据自己的exception和错误内容，编制错误页面
        if(ex instanceof UnauthorizedException) {  
            return new ModelAndView("error/403", model);  
        }else if(ex instanceof DataAccessDeniedException) {  
            return new ModelAndView("error/403", model);  
        } else if(ex instanceof DataAccessDeniedException) {  
            return new ModelAndView("error/403", model);  
        } else {  
            return new ModelAndView("error/500", model);  
        }  
    }  
}  

