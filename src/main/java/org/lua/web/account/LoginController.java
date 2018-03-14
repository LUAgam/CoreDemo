package org.lua.web.account;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.lua.constant.Constant;
import org.lua.entity.Menu;
import org.lua.entity.MessageRepient;
import org.lua.entity.Role;
import org.lua.entity.User;
import org.lua.service.account.AccountService;
import org.lua.service.admin.LoginLogService;
import org.lua.service.admin.MessageRepientService;
import org.lua.service.admin.MessageService;
import org.lua.service.configuration.MenuService;
import org.lua.service.configuration.RoleMenuService;
import org.lua.util.UserUtils;
import org.lua.web.account.formbean.AccountFB;
import org.lua.web.index.formbean.MessageRepientFB;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.persistence.criteria.*;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * LoginController负责打开登录页面(GET请求)和登录出错页面(POST请求)，
 * <p>
 * 真正登录的POST请求由Filter完成,
 *
 * @author JHuang
 */
@Controller
@SessionAttributes(value = {"allMenu", "currentUser", "allRootMenu", "unReadCount", "messageLists", "unReadNotificationCount", "unReadNotificationList", "approveReList", "unFinishCount"})
@RequestMapping(value = "/login")
public class LoginController {

    final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    AccountService accountService;

    @Autowired
    LoginLogService loginlogService;

    @Autowired
    MenuService menuService;

    @Autowired
    MessageService messageService;

    @Autowired
    private RoleMenuService roleMenuService;


    @Autowired
    private MessageRepientService messageRepientService;

    @RequestMapping(method = RequestMethod.GET)
    public String do_get() {
        if (UserUtils.getCurrentUser() != null) {
            return "redirect:/index";
        }

        return "account/login";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String do_post(@ModelAttribute(value = "user") AccountFB userFB, Model model, HttpSession session) {
        userFB.setUsername(userFB.getUsername().trim());
        if ("".equals(userFB.getUsername()) && "".equals(userFB.getPassword())) {
            logger.info("用户名和密码不能为空");
            // 从cookie中读取用户名字
            /*
             * String cookieUserName =
             * CookieUtils.getUserNameFromCookie(request);
             * if(StringUtils.isNotBlank(cookieUserName)){
             * modelMap.addAttribute("username",cookieUserName); }
             */
            model.addAttribute("message", Constant.ERRORINFO_LOGINCONTROLLER_USE_PASSWORD_NOTNULL);
            return "account/login";
        }

        /* check captcha */
        // String captcha1 =
        // (String)session.getAttribute(Constants.SESSION_CAPTCHA);

        /*
         * 取消验证码的功能 if(!(captcha1 != null && captcha != null &&
         * captcha1.toUpperCase().equals(captcha.toUpperCase()))){
         * logger.debug("验证码不匹配"); modelMap.addAttribute("username",username);
         * modelMap.addAttribute("password",password);
         * modelMap.addAttribute("loginError","验证码错误"); return "login"; }
         */

        Subject user = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userFB.getUsername(), userFB.getPassword());
        token.setRememberMe(userFB.isRememberme());

        User currentUser = accountService.findUserByUsername(userFB.getUsername());

        if (currentUser == null) {
            logger.info("用户名错误");

            model.addAttribute("username", userFB.getUsername());
            model.addAttribute("password", userFB.getPassword());
            model.addAttribute("errorUsername", true);
            model.addAttribute("message", Constant.ERRORINFO_LOGINCONTROLLER_USENAME_ERROR);

            return "account/login";
        }

        // 从cookie中读取用户名字
        /*
         * String cookieUserName = CookieUtils.getUserNameFromCookie(request);
         * if(StringUtils.isNotBlank(cookieUserName)){
         * modelMap.addAttribute("username",cookieUserName); }
         */

        if (currentUser.isLoginAllowed() == false) {
            logger.info("该账号未开启");

            model.addAttribute("username", userFB.getUsername());
            model.addAttribute("password", userFB.getPassword());
            model.addAttribute("errorUsername", true);
            model.addAttribute("message", Constant.ERRORINFO_LOGINCONTROLLER_NO_USENAME);
            return "account/login";
        }

        if (currentUser.getPerson() != null && currentUser.getPerson().isDimission() == true) {
            logger.info("该用户已离职");

            model.addAttribute("username", userFB.getUsername());
            model.addAttribute("password", userFB.getPassword());
            model.addAttribute("errorUsername", true);
            model.addAttribute("message", Constant.ERRORINFO_LOGINCONTROLLER_LEAVE);

            return "account/login";
        }

        try {
            user.login(token);
            logger.info(userFB.getUsername() + Constant.LOGIN_SUCCESS);

            // 登录成功记录coockie
            // CookieUtils.rememberMe(username, request, response);

            UserUtils.setCurrentUser(currentUser, currentUser.getPerson(), currentUser.getPerson().getDepartment());
            if ("admin".equals(userFB.getUsername().toLowerCase())) {
                UserUtils.setAdmin(true);
            } else {
                UserUtils.setAdmin(false);
            }
            //准备菜单数据
            List<Role> roleList = accountService.getRoleListByUser(currentUser);
            List<Menu> allMenu = new ArrayList<Menu>();
            for (Role role : roleList) {
                allMenu.addAll(roleMenuService.getMenuByRole(role.getId()));
            }
            UserUtils.setUserMenuList(allMenu);
            model.addAttribute("currentUser", currentUser);
            model.addAttribute("allMenu", allMenu);

            // 更新commonNav上的信息
            Pageable msgPageRequest = new PageRequest(0, 3, new Sort(new Sort.Order(Sort.Direction.ASC, "message.datetime")));
            Page<MessageRepient> messageRepientList = messageRepientService.findAll(new Specification<MessageRepient>() {
                @Override
                public Predicate toPredicate(Root<MessageRepient> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                    Path<User> recipientPath = root.get("repientUser");
                    Path<Integer> recipientidPath = recipientPath.get("id");

                    Path<Boolean> readPath = root.get("read");

                    criteriaQuery.where(criteriaBuilder.equal(recipientidPath, UserUtils.getCurrentUser().getId()), criteriaBuilder.equal(readPath, false));
                    return null;
                }
            }, msgPageRequest);
            List<MessageRepientFB> messageRepientFBList = new LinkedList<MessageRepientFB>();
            MessageRepientFB messageRepientFB;
            for (MessageRepient messageRepient : messageRepientList) {
                messageRepientFB = MessageRepientFB.toFB(messageRepient);
                messageRepientFBList.add(messageRepientFB);
            }
            model.addAttribute("messageLists", messageRepientFBList);
            model.addAttribute("unReadCount", messageRepientService.findUnreadCount(UserUtils.getCurrentUser().getId()));

            loginlogService.login(currentUser, session.getId());
            return "redirect:/admin";
        } catch (AuthenticationException e) {
            logger.error("输入密码错误", e);
            e.printStackTrace();
            model.addAttribute("username", userFB.getUsername());
            model.addAttribute("password", userFB.getPassword());
            model.addAttribute("errorPassword", true);
            model.addAttribute("message", Constant.ERRORINFO_LOGINCONTROLLER_PASSWORD_ERROR);
            return "account/login";
        }

    }
}
