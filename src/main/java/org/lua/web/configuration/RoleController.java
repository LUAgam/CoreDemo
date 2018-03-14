/**
 * (c) 2006 JOVEN
 * <p>
 * http://www.joven.com.cn
 */

package org.lua.web.configuration;

import org.apache.commons.lang3.StringUtils;
import org.lua.constant.Constant;
import org.lua.constant.ResourceFactory;
import org.lua.annotation.Token;
import org.lua.entity.Resource;
import org.lua.entity.Role;
import org.lua.entity.RoleMenu;
import org.lua.service.account.AccountService;
import org.lua.service.configuration.MenuService;
import org.lua.service.configuration.RoleMenuService;
import org.lua.service.configuration.RolePermissionService;
import org.lua.service.configuration.RoleService;
import org.lua.util.ErrorUtils;
import org.lua.web.BaseController;
import org.lua.web.PageParam;
import org.lua.web.configuration.formbean.ResourceFB;
import org.lua.web.configuration.formbean.RoleFB;
import org.lua.web.configuration.formbean.RoleMenuFB;
import org.lua.web.configuration.formbean.RolePermissionFB;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 *
 * @author $Author: JHuang $
 * @version $Revision: 4306 $ $Date: 2014-05-08 18:22:19 +0800 (星期四, 08 五月 2014)
 *          $
 */
@Controller
@RequestMapping(value = "/admin/auth/role")
public class RoleController extends BaseController {
    @Autowired
    RoleService roleService;

    @Autowired
    RolePermissionService rolepermissionService;

    @Autowired
    private RoleMenuService roleMenuService;

    @Autowired
    private MenuService menuService;

    @Autowired
    private AccountService accountService;

    /**
     * 模块界面请求
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String do_get(HttpServletRequest request, Model model) {
        // 设置数据和分页信息
        PageParam pp = readPageRequest(request);
        PageRequest pageRequest = new PageRequest(pp.getPageNumber(), pp.getPageSize(), new Sort(Sort.Direction.DESC, Constant.DEFAULT_SORT_KEY));
        model.addAttribute("roleList", roleService.getPage(pageRequest));
        return "configuration/role/list";
    }

    /**
     * 角色table的json请求
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public String list(HttpServletRequest request, Model model) {
        // 得到整个请求的参数
        PageParam pp = readPageRequest(request);
        // 设置数据和分页信息
        PageRequest pageRequest = new PageRequest(pp.getPageNumber(), pp.getPageSize(), new Sort(Sort.Direction.DESC, Constant.DEFAULT_SORT_KEY));

        model.addAttribute("roleList",
                roleService.getPage(builderSearchString(pp.getSearchParamter().keySet()), pp.getSearchParamter().values().toArray(), pageRequest));
        // 回写搜索参数
        writePageRequest(model, pp);
        return "configuration/role/list";
    }

    /**
     * 新增
     *
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    @Token(save = true)
    public String do_add() {
        return "configuration/role/edit";
    }

    /**
     * 编辑
     *
     * @param roleId
     * @param map
     * @return
     */
    @RequestMapping(value = "/edit/{roleId}", method = RequestMethod.GET)
    @Token(save = true)
    public String do_edit(@PathVariable("roleId") Long roleId, ModelMap map) {
        Role entity = roleService.findOne(roleId);
        RoleFB roleFB = new RoleFB();
        BeanUtils.copyProperties(entity, roleFB);

        map.addAttribute("role", roleFB);
        return "configuration/role/edit";
    }

    /**
     * 保存
     *
     * @param result
     * @param map
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @Token(remove = true)
    public String do_save(@ModelAttribute @Valid RoleFB roleFB, BindingResult result, ModelMap map, HttpServletRequest request) {
        String token = request.getParameter("token");
        if (result.hasErrors()) {
            map.addAttribute("message", ErrorUtils.fetchAllErrorMessages(result));
            map.addAttribute("role", roleFB);
            return "configuration/role/edit";
        }
        Role roleEntity;
        if (roleFB.getId() != null) {
            roleEntity = roleService.findOne(roleFB.getId());
        } else {
            roleEntity = new Role();
        }
        BeanUtils.copyProperties(roleFB, roleEntity);
        roleService.saveRole(roleEntity);
        return "redirect:/admin/auth/role";
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String do_delete(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        try {

            Role role = roleService.findOne(id);
            if (role.getRolePermissions().isEmpty() && role.getUserRoles().isEmpty()) {
                roleService.remove(id);
            } else {
                redirectAttributes.addFlashAttribute("message", Constant.DELETE_MESSAGE);
            }
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", Constant.DELETE_MESSAGE);
        }
        return "redirect:/admin/auth/role";
    }

    /**
     * 显示角色所有的权限
     *
     * @return
     */
    @RequestMapping(value = "/permission/{roleId}", method = RequestMethod.GET)
    public String do_rolepermission(@PathVariable("roleId") Long roleId, ModelMap map) {
        ResourceFactory factory = ResourceFactory.getInstance();
        // 所有资源，不同类型的资源分别放到不同list中
        Map<String, List<ResourceFB>> allResouceMap = new HashMap<String, List<ResourceFB>>();
        // 所有已拥有的资源，不同类型的资源分别放到不同list中
        Map<String, List<ResourceFB>> selectedResouceMap = new HashMap<String, List<ResourceFB>>();
        // 所有资源类型
        List<String> resourceTypes = factory.getAllResourceType();
        // 当前角色拥有的权限
        List<String> selectPermissionName = rolepermissionService.findNameByRole(roleId);
        if (resourceTypes.size() > 0) {
            for (String type : resourceTypes) {
                // 获得当前类型的resource
                List<Resource> resourceList = factory.getResourceListByType(type);

                List<ResourceFB> resourceFBList = new ArrayList<ResourceFB>();
                List<ResourceFB> selectedResourceFBList = new ArrayList<ResourceFB>();
                if (resourceList != null) {
                    for (Resource r : resourceList) {
                        ResourceFB fb = new ResourceFB();
                        BeanUtils.copyProperties(r,fb);
                        // 判断当前角色是否已拥有该权限
                        if (selectPermissionName.contains(r.getName())) {
                            fb.setSelected(true);
                            selectedResourceFBList.add(fb);
                        }
                        resourceFBList.add(fb);
                    }
                    allResouceMap.put(type, resourceFBList);
                    selectedResouceMap.put(type, selectedResourceFBList);
                }

            }
        }
        map.addAttribute("role", roleService.findOne(roleId));
        map.addAttribute("resourceTypes", resourceTypes);
        map.addAttribute("allResouceMap", allResouceMap);
        map.addAttribute("selectedResouceMap", selectedResouceMap);
        return "configuration/role/rolepermission";

    }

    /**
     * 保存角色的所有权限
     *
     * @param roleId
     * @param map
     * @return
     */
    @RequestMapping(value = "/saveRolePermission", method = RequestMethod.POST)
    public String save_rolepermission(@RequestParam(value = "roleId") Long roleId, @RequestParam(value = "selectName") String selectName, ModelMap map) {
        List<String> names = new ArrayList<String>();
        if (StringUtils.isNotBlank(selectName)) {
            String[] split = selectName.split(",");
            for (String str : split) {
                if (StringUtils.isNotBlank(str) && str.indexOf("select_") >= 0) {
                    names.add(str.substring(7));
                }
            }
            rolepermissionService.save(roleId, (String[]) names.toArray(new String[names.size()]));
        }

        return "redirect:/admin/auth/role";

    }

    /**
     * 新增一条权限
     *
     * @param roleId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/saveOnePermission", method = RequestMethod.POST)
    public void addOnePermission(@RequestParam(value = "roleId") Long roleId, @RequestParam(value = "name") String name) {
        rolepermissionService.saveOnePermission(roleId, name);

    }

    /**
     * 删除一条权限
     *
     * @param roleId
     */
    @ResponseBody
    @RequestMapping(value = "/deleteOnePermission", method = RequestMethod.POST)
    public void deleteOnePermission(Long roleId, String name) {
//		name=name.replace(":", "\\:");
        rolepermissionService.deleteOnePermission(roleId, name);

    }

    /**
     * 打开角色菜单配置界面
     *
     * @param roleId
     * @param model
     * @return
     */
    @RequestMapping(value = "/menu/{roleId}", method = RequestMethod.GET)
    public String do_rolemenu(@PathVariable("roleId") Long roleId, Model model) {
        Role role = roleService.findOne(roleId);
        model.addAttribute("role", role);
        model.addAttribute("roleId", roleId);
        return "configuration/role/rolemenu";
    }

    /**
     * 获取所有menu信息
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/menu/jsonData", method = RequestMethod.GET)
    public List<Resource> getMenuJsonData() {
        List<Resource> resources = ResourceFactory.getInstance().getResourceListByType(Constant.RESOURCE_MENU);
        return resources;
    }

    /**
     * 获取本角色的menu信息
     *
     * @return
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    @ResponseBody
    @RequestMapping(value = "/menu/roleJsonData", method = RequestMethod.GET)
    public List<RoleMenuFB> getRoleJsonData(@RequestParam(value = "roleId") String roleId) throws IllegalAccessException, InvocationTargetException {
        List<RoleMenu> roleMenuList = roleMenuService.findByRole(Long.parseLong(roleId));
        List<RoleMenuFB> roleMenuFBList = roleMenuService.toFB(roleMenuList);
        return roleMenuFBList;
    }

    @ResponseBody
    @RequestMapping(value = "/saveRoleMenu", method = RequestMethod.POST)
    public String saveRoleMenu(@RequestBody List<RoleMenuFB> nodes) {

        try {
            if (nodes.size() > 0) {
                roleMenuService.deleteRoleMenu(Long.parseLong(nodes.get(0).getRole()));
                roleMenuService.saveRoleMenuFBList(nodes);
            }
            return "success";
        } catch (Exception e) {
            System.err.println(e.getLocalizedMessage());
            return "failed";
        }
    }

    /**
     * 显示角色所有的权限
     *
     * @return
     */
    @RequestMapping(value = "/permission", method = RequestMethod.POST)
    public String do_save_rolepermission(@ModelAttribute RolePermissionFB rolePermissionFB) {

        rolepermissionService.save(rolePermissionFB.getRoleId(), rolePermissionFB.getSelectpermission());

        return "redirect:/admin/auth/role";

    }
}
