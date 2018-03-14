package org.lua.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.lua.service.admin.LoginLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;


/**
 * Created with IntelliJ IDEA.
 * User: kady
 * Date: 13-12-19
 * Time: 上午11:25
 * To change this template use File | Settings | File Templates.
 */
public class HttpSessionListenerImpl implements HttpSessionListener {

    private static Logger logger = LoggerFactory.getLogger(HttpSessionListenerImpl.class);

    public void sessionCreated(HttpSessionEvent se) {
        logger.info("build session id:" + se.getSession().getId());
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        logger.info("destroy session id:" + se.getSession().getId());

        //销毁session的时候，关闭使用这个session的用户的登录状态，
        String sessionId = se.getSession().getId();
        if (!StringUtils.isEmpty(sessionId)) {

            ServletContext servletContext = se.getSession().getServletContext();
            WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);


            LoginLogService loginLogService = webApplicationContext.getBean(LoginLogService.class);

            if (loginLogService != null) {

                loginLogService.logout(sessionId);

                logger.info("the session reflect the user not exist for session ID : " + sessionId);
            } else {
                logger.info("web context get the user manager failed !");
            }
        }
    }
}
