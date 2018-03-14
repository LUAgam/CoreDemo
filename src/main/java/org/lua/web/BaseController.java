/**
 * (c) 2006 Joven
 * 
 * http://www.joven.com.cn 版权所有 2006 上海悦闻信息技术有限公司
 */
package org.lua.web;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import javax.servlet.ServletRequest;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

import org.apache.commons.lang3.Validate;
import org.lua.constant.Constant;
import org.lua.beanvalidator.BeanValidators;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.schickit.utils.DateUtils;

/**
 * 控制器支持类
 * 
 * @version 2013-3-23
 */
public abstract class BaseController {

	/**
	 * 日志对象
	 */
	protected Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 验证Bean实例对象
	 */
	@Autowired
	protected Validator validator;

	/**
	 * 服务端参数有效性验证
	 * 
	 * @param object
	 *            验证的实体对象
	 * @param groups
	 *            验证组
	 * @return 验证成功：返回true；严重失败：将错误信息添加到 message 中
	 */
	protected boolean beanValidator(Model model, Object object, Class<?>... groups) {
		try {
			BeanValidators.validateWithException(validator, object, groups);
		} catch (ConstraintViolationException ex) {
			List<String> list = BeanValidators.extractPropertyAndMessageAsList(ex, ": ");
			list.add(0, "数据验证失败：");
			addMessage(model, list.toArray(new String[] {}));
			return false;
		}
		return true;
	}

	/**
	 * 服务端参数有效性验证
	 * 
	 * @param object
	 *            验证的实体对象
	 * @param groups
	 *            验证组
	 * @return 验证成功：返回true；严重失败：将错误信息添加到 flash message 中
	 */
	protected boolean beanValidator(RedirectAttributes redirectAttributes, Object object, Class<?>... groups) {
		try {
			BeanValidators.validateWithException(validator, object, groups);
		} catch (ConstraintViolationException ex) {
			List<String> list = BeanValidators.extractPropertyAndMessageAsList(ex, ": ");
			list.add(0, "数据验证失败：");
			addMessage(redirectAttributes, list.toArray(new String[] {}));
			return false;
		}
		return true;
	}

	/**
	 * 添加Model, formbean错误验证信息
	 * 
	 * @param messages
	 *            消息
	 */
	protected void addMessage(Model model, BindingResult result) {
		List<ObjectError> ls = result.getAllErrors();
		List<String> errors = new ArrayList<String>(ls.size());
		for (ObjectError oError : ls) {
			errors.add(oError.getDefaultMessage());
		}
		addMessage(model, errors.toArray(new String[errors.size()]));
	}

	/**
	 * 添加Model消息
	 * 
	 * @param messages
	 *            消息
	 */
	protected void addMessage(Model model, String... messages) {
		StringBuilder sb = new StringBuilder();
		for (String message : messages) {
			sb.append(message).append(messages.length > 1 ? "<br/>" : "");
		}
		model.addAttribute("message", sb.toString());
	}

	/**
	 * 添加Flash消息
	 * 
	 * @param messages
	 *            消息
	 */
	protected void addMessage(RedirectAttributes redirectAttributes, String... messages) {
		StringBuilder sb = new StringBuilder();
		for (String message : messages) {
			sb.append(message).append(messages.length > 1 ? "<br/>" : "");
		}
		redirectAttributes.addFlashAttribute("message", sb.toString());
	}

	/**
	 * 初始化数据绑定 1. 将所有传递进来的String进行HTML编码，防止XSS攻击 2. 将字段中Date类型转换为String类型
	 */
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		// String类型转换，将所有传递进来的String进行HTML编码，防止XSS攻击
		binder.registerCustomEditor(String.class, new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) {
				setValue(text == null ? null : text.trim());
			}

			@Override
			public String getAsText() {
				Object value = getValue();
				return value != null ? value.toString() : "";
			}
		});
		// Date 类型转换
		binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) {
				try {
					setValue(DateUtils.parseAnyString(text));
				} catch (ParseException e) {
					logger.error("error while parse Date format String!", e);
				}
			}
		});
	}

	/**
	 * 读取分页搜索的分页信息，搜索信息
	 */
	protected PageParam readPageRequest(ServletRequest request) {
		
		PageParam pp = new PageParam();

		Map<String, Object> pageParameter = getParametersStartingWith(request, Constant.PRE_PAGE);

		String type = Constant.LIST_TYPE;
		
		String export = request.getParameter("EXPORT");
		if (export != null && "1".equals(export)) {
			type = Constant.EXCEL_TYPE;
		}	
		
		int pageNumber = Constant.DEFAULT_START_PAGE;
		int pageSize = Constant.DEFAULT_PAGE_SIZE;

		if (pageParameter.get(Constant.PAGE_TYPE_KEY) != null) {
			type = pageParameter.get(Constant.PAGE_TYPE_KEY).toString();
		}

		if (pageParameter.get(Constant.PAGE_NUMBER_KEY) != null) {
			pageNumber = Integer.valueOf(pageParameter.get(Constant.PAGE_NUMBER_KEY).toString());
		}

		if (pageParameter.get(Constant.PAGE_SIZE_KEY) != null) {
			pageSize = Integer.valueOf(pageParameter.get(Constant.PAGE_SIZE_KEY).toString());
		}

		pp.setType(type);
		pp.setPageNumber(pageNumber);
		pp.setPageSize(pageSize);

		Map<String, Object> searchParamter = getSearchParamter(request);
		pp.setSearch(searchParamter);

		for (String searchKey : searchParamter.keySet()) {
			String[] searchArray = searchKey.split("@");
			if (searchArray != null && searchArray.length == 3 && searchParamter.get(searchKey) != null
					&& searchParamter.get(searchKey).toString().length() > 0) {
				PageSearchKey pageSearchKey = new PageSearchKey();
				pageSearchKey.setSearchKey(searchArray[0]);
				pageSearchKey.setSearchOperat(searchArray[1]);
				pageSearchKey.setType(searchArray[2]);
				pageSearchKey.setSearchValue(searchParamter.get(searchKey).toString());
				// 判断类型
				if (PageSearchKey.TEXT.equals(pageSearchKey.getType())) {
					// 文本型数据框
					if (PageSearchKey.LIKE.equals(pageSearchKey.getSearchOperat())) {
						pp.addSearchParamter(pageSearchKey, "%" + searchParamter.get(searchKey).toString() + "%");
					} else if (PageSearchKey.EQ.equals(pageSearchKey.getSearchOperat())) {
						pp.addSearchParamter(pageSearchKey, searchParamter.get(searchKey));
					}
				} else if (PageSearchKey.DATE.equals(pageSearchKey.getType())) {
					// 日期输入（只能相等）
					if (PageSearchKey.EQ.equals(pageSearchKey.getSearchOperat())) {
						try {
							pp.addSearchParamter(pageSearchKey,
									DateUtils.parseAnyString(searchParamter.get(searchKey).toString()));
						} catch (ParseException e) {
							logger.warn("日期查询搜索框传来的值不是日期格式 YYYY-MM-DD 而是：" + searchParamter.get(searchKey).toString());
						}
					}
				} else if (PageSearchKey.DATERNAGE.equals(pageSearchKey.getType())) {
					// 时间间隔
					if (PageSearchKey.BIGERTHAN_EQ.equals(pageSearchKey.getSearchOperat())) {
						try {
							pp.addSearchParamter(pageSearchKey,
									DateUtils.parseAnyString(searchParamter.get(searchKey).toString()));
						} catch (ParseException e) {
							logger.warn("日期查询搜索框传来的值不是日期格式 YYYY-MM-DD 或 YYYY-MM-DD hh:mm:ss 而是：" + searchParamter.get(searchKey).toString());
						}
					} else if (PageSearchKey.THINTHAN.equals(pageSearchKey.getSearchOperat())) {
						try {
							pp.addSearchParamter(pageSearchKey, DateUtils
									.incDay(DateUtils.parseAnyString(searchParamter.get(searchKey).toString()), 1));
						} catch (ParseException e) {String header = request.getParameter("HEADER");
						System.err.println(header);
							logger.warn("日期查询搜索框传来的值不是日期格式 YYYY-MM-DD 或 YYYY-MM-DD hh:mm:ss 而是：" + searchParamter.get(searchKey).toString());
						}
					}
				} else if (PageSearchKey.OPTIONSENTITY.equals(pageSearchKey.getType())) {
					pp.addSearchParamter(pageSearchKey, Long.valueOf(searchParamter.get(searchKey).toString()));
				} else if (PageSearchKey.OPTIONS.equals(pageSearchKey.getType())) {
					pp.addSearchParamter(pageSearchKey, searchParamter.get(searchKey).toString());
				}
			}

		}
		
		Map<String, String> exportParameter = new LinkedHashMap<String, String>();
		Map<String, Object> exp = getParametersStartingWith(request, "HEADER_");
		for (String s : exp.keySet()) {
			exportParameter.put((String)exp.get(s), s);
		}
		pp.setExportParamter(exportParameter);
	
		return pp;
	}

	/**
	 * 将搜索关键字和查询内容写回model TODO 排序
	 */
	protected void writePageRequest(Model model, PageParam pp) {
		for (PageSearchKey psk : pp.getSearchParamter().keySet()) {
			if (PageSearchKey.DATERNAGE.equals(psk.getType())) {
				if (PageSearchKey.THINTHAN.equals(psk.getSearchOperat())) {
					model.addAttribute(Constant.PRE_SEARCH + "END_" + psk.getSearchKey().replace(".", "_"),
							psk.getSearchValue());
				} else if (PageSearchKey.BIGERTHAN_EQ.equals(psk.getSearchOperat())) {
					model.addAttribute(Constant.PRE_SEARCH + "START_" + psk.getSearchKey().replace(".", "_"),
							psk.getSearchValue());
				}
			} else {
				model.addAttribute(Constant.PRE_SEARCH + psk.getSearchKey().replace(".", "_"), psk.getSearchValue());
			}

		}

		model.addAllAttributes(pp.getSearch());
	}

	private Map<String, Object> getSearchParamter(ServletRequest request) {
		Map<String, Object> searchMap = getParametersStartingWith(request, Constant.PRE_SEARCH);
		Map<String, Object> retMap = new TreeMap<String, Object>();
		for (String search : searchMap.keySet()) {
			Object value = searchMap.get(search);
			if (value != null && value instanceof String && ((String) value).length() > 0) {
				retMap.put(search, value);
			}
		}

		return retMap;
	}

	/**
	 * 拼接sql
	 */
	protected String builderSearchString(Collection<PageSearchKey> keyCollection) {
		String where = "";
		for (PageSearchKey key : keyCollection) {
			where += key.getSearchKey() + " " + PageSearchKey.getOperatByName(key.getSearchOperat()) + " ?";
			where += " AND ";
		}

		if (where.length() > 0) {
			where = where.substring(0, where.length() - 5);
		}
		return where;
	}

	/**
	 * 取得带相同前缀的Request Parameters
	 * 
	 * 返回的结果的Parameter名已去除前缀.
	 */
	@SuppressWarnings("rawtypes")
	public Map<String, Object> getParametersStartingWith(ServletRequest request, String prefix) {
		Validate.notNull(request, "Request must not be null");
		Enumeration paramNames = request.getParameterNames();
		Map<String, Object> params = new TreeMap<String, Object>();
		String pre = prefix;
		if (pre == null) {
			pre = "";
		}
		while (paramNames != null && paramNames.hasMoreElements()) {
			String paramName = (String) paramNames.nextElement();
			if ("".equals(pre) || paramName.startsWith(pre)) {
				String unprefixed = paramName.substring(pre.length());
				String[] values = request.getParameterValues(paramName);
				if (values == null || values.length == 0) {
					values = new String[] {};
					// Do nothing, no values found at all.
				} else if (values.length > 1) {
					params.put(unprefixed, values);
				} else {
					params.put(unprefixed, values[0]);
				}
			}
		}
		return params;
	}

	/**
	 * 组合Parameters生成Query String的Parameter部分,并在paramter name上加上prefix.
	 * 
	 */
	public String encodeParameterStringWithPrefix(Map<String, Object> params, String prefix) {
		StringBuilder queryStringBuilder = new StringBuilder();

		String pre = prefix;
		if (pre == null) {
			pre = "";
		}
		Iterator<Entry<String, Object>> it = params.entrySet().iterator();
		while (it.hasNext()) {
			Entry<String, Object> entry = it.next();
			queryStringBuilder.append(pre).append(entry.getKey()).append("=").append(entry.getValue());
			if (it.hasNext()) {
				queryStringBuilder.append("&");
			}
		}
		return queryStringBuilder.toString();
	}

}
