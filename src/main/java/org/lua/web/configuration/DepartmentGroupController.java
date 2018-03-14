package org.lua.web.configuration;

import org.apache.commons.lang3.StringUtils;
import org.lua.entity.Department;
import org.lua.entity.User;
import org.lua.entity.UserGroup;
import org.lua.service.configuration.*;
import org.lua.util.UserUtils;
import org.lua.web.BaseController;
import org.lua.web.PageParam;
import org.lua.web.configuration.formbean.UserFB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 本部门岗位管理
 *
 * @author ZZWang
 * @Time 2017年3月31日 下午4:35:11
 */
@Controller
@RequestMapping(value = "/admin/auth/depgroup")
public class DepartmentGroupController extends BaseController {

    @Autowired
    GroupService groupService;

    @Autowired
    UserGroupService ugService;

    @Autowired
    DepartmentGroupService dgService;

    @Autowired
    DepartmentService depService;

    @Autowired
    UserService userService;

    Long depId = -1L;
    Department department;

    // private static Logger logger =
    // Logger.getLogger(UserGroupController.class);

    @ModelAttribute
    public void init() {
        department = UserUtils.getCurrentUser().getPerson().getDepartment();
        if (department != null) {
            depId = department.getId();
        }
    }

    /**
     * 当前用户所属部门所有岗位信息
     */
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String get(HttpServletRequest request, Model model) {

        // 设置数据和分页信息
        PageParam pp = readPageRequest(request);
        PageRequest pageRequest = new PageRequest(pp.getPageNumber(), pp.getPageSize(), new Sort(Sort.Direction.DESC, "id"));
        String searchString = builderSearchString(pp.getSearchParamter().keySet());
        // 查询部门下所有岗位
        if (StringUtils.isBlank(searchString)) {
            searchString += " entity.dep.id=?";
        } else
            searchString += " and entity.dep.id=?";

        List<Object> paramList = new ArrayList<Object>(Arrays.asList(pp.getSearchParamter().values().toArray()));
        paramList.add(depId);
        model.addAttribute("depGroupList", dgService.getPage(searchString, paramList.toArray(), pageRequest));
        // 回写搜索参数
        writePageRequest(model, pp);
        return "/configuration/depgroup/groupList";
    }

    /**
     * 当前岗位用户配置
     *
     * @return
     */
    @RequestMapping(value = "/editUserGroup/{groupId}", method = {RequestMethod.GET, RequestMethod.POST})
    public String editUserGroup(@PathVariable("groupId") Long groupId, HttpServletRequest request, HttpServletResponse response, Model model) {
        //本部门所有的用户
        List<User> allUsers = userService.findByDepartment(depId);
        //本部门所有用户
        List<UserFB> allUsersFB = new ArrayList<UserFB>();
        //本部门拥有该岗位的所有用户
        List<UserFB> selectUsersFB = new ArrayList<UserFB>();
        List<String> selectUsernames = ugService.findUsernameByGroupAndDep(groupId, depId);
        for (User user : allUsers) {
            UserFB userFB = UserFB.toFB(user);
            if (selectUsernames.contains(user.getUsername())) {
                userFB.setIsSelect(true);
                selectUsersFB.add(userFB);
            }
            allUsersFB.add(userFB);
        }

        model.addAttribute("allUsers", allUsersFB);
        model.addAttribute("selectUsers", selectUsersFB);
        model.addAttribute("group", groupService.findOne(groupId));
        return "configuration/depgroup/userGroup";
    }

    /**
     * 向岗位中添加用户
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/saveUserGroup/{groupId}", method = {RequestMethod.POST})
    public void saveUserGroup(@PathVariable("groupId") Long groupId, @RequestParam(value = "userId") Long userId, HttpServletRequest request, HttpServletResponse response, Model model) {
        UserGroup userGroup = new UserGroup();
        userGroup.setGroup(groupService.findOne(groupId));
        userGroup.setUser(userService.findOne(userId));
        ugService.save(userGroup);
    }

    /**
     * 删除岗位中用户
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deleteUserGroup/{groupId}", method = {RequestMethod.POST})
    public void deleteUserGroup(@PathVariable("groupId") Long groupId, @RequestParam(value = "userId") Long userId, HttpServletRequest request, HttpServletResponse response, Model model) {
        ugService.deleteByUserAndGroup(userId, groupId);
    }

    /**
     * 编辑当班配置
     *
     * @return
     */
    @RequestMapping(value = "/editOnWork/{groupId}", method = {RequestMethod.GET, RequestMethod.POST})
    public String editOnWork(@PathVariable("groupId") Long groupId, HttpServletRequest request, HttpServletResponse response, Model model) {

        //找到当前部门下此岗位的所有用户
        List<UserGroup> allUserGroup = ugService.findByGroupAndDep(groupId, depId);
        model.addAttribute("userGroupList", allUserGroup);
        model.addAttribute("group", groupService.findOne(groupId));
        return "configuration/depgroup/onWork";
    }

    /**
     * 保存当班配置
     *
     * @return
     */
    @RequestMapping(value = "/saveOnWork/{groupId}", method = {RequestMethod.GET, RequestMethod.POST})
    public String saveOnWork(@PathVariable("groupId") Long groupId, @RequestParam(value = "rowcheck") Long[] rowcheck, HttpServletRequest request, HttpServletResponse response, Model model) {
        //将该岗位下的所有用户设为非当班状态
        ugService.updateOnWork(groupId, depId);
        for (Long id : rowcheck) {
            UserGroup userGroup = ugService.findOne(id);
            userGroup.setIsOnWork(true);
            ugService.save(userGroup);
        }
        return "redirect:/admin/auth/depgroup";
    }
}
