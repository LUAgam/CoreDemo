/**
 * (c) 2010 SDGroup
 * <p>
 * http://www.sdgroup.com
 */

package org.lua.web.configuration;

import org.lua.constant.Constant;
import org.lua.datatables.JSONParam;
import org.lua.datatables.JSONResponse;
import org.lua.entity.Tenant;
import org.lua.service.configuration.TenantService;
import org.lua.util.ErrorUtils;
import org.lua.util.JSONParamUtils;
import org.lua.util.JSONResponseUtils;
import org.lua.web.configuration.formbean.TenantFB;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.HashMap;

/**
 * 域Action
 * @author $Author: XLShu$
 * @version $Revision: 4306 $Date: 2014-1-9上午10:55:05$
 *
 */
@Controller
@RequestMapping(value = "/tenant")
public class TenantController {

    @Autowired
    TenantService tenantService;

    /**
     * 界面请求
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String do_get() {
        return "configuration/tenant/list";
    }

    /**
     * 域 table的json请求
     * @param params
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public @ResponseBody
    JSONResponse list(@RequestBody JSONParam[] params) {
        HashMap<String, String> paramMap = JSONParamUtils.convertToMap(params);

        int length = Integer.parseInt(paramMap.get("iDisplayLength"));
        int page = Integer.parseInt(paramMap.get("iDisplayPage"));

        Pageable pr = new PageRequest(page, length, new Sort(new Order(Direction.ASC, "id")));
        Page<Tenant> tenantPage = tenantService.findAll(pr);

        return JSONResponseUtils.convert(tenantPage, paramMap);
    }

    /**
     * 新增
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String do_add() {
        return "configuration/tenant/edit";
    }

    /**
     * 编辑
     * @param tenantId
     * @param map
     * @return
     */
    @RequestMapping(value = "/edit/{tenantId}", method = RequestMethod.GET)
    public String do_edit(@PathVariable("tenantId") Long tenantId, ModelMap map) {
        Tenant tenantEntity = tenantService.findOne(tenantId);
        TenantFB tenantFB = new TenantFB();
        BeanUtils.copyProperties(tenantEntity, tenantFB);
        map.addAttribute("tenant", tenantFB);
        return "configuration/tenant/edit";
    }

    /**
     * 保存
     * @param tenant
     * @param result
     * @param map
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String do_save(@ModelAttribute @Valid TenantFB tenant, BindingResult result, ModelMap map) {
        if (result.hasErrors()) {
            map.addAttribute("message", ErrorUtils.fetchAllErrorMessages(result));
            map.addAttribute("tenant", tenant);
            return "tenant/edit";
        }
        Tenant entity;
        if (tenant.getId() != null) {
            entity = tenantService.findOne(tenant.getId());
        } else {
            entity = new Tenant();
        }
        BeanUtils.copyProperties(tenant, entity);
        tenantService.saveTenant(entity);

        return "redirect:/tenant";
    }

    /**
     * 移除
     * @param tenantId
     * @return
     */
    @RequestMapping(value = "/delete/{tenantId}", method = RequestMethod.GET)
    public String do_delete(@PathVariable("tenantId") Long tenantId, RedirectAttributes redirectAttributes) {
        try {
            tenantService.remove(tenantId);
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", Constant.DELETE_MESSAGE);
        }

        return "redirect:/tenant";
    }

}

