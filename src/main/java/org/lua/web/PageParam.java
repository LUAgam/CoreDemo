/**
 *        (c) 2006 Joven 
 *
 *        http://www.joven.com.cn
 *        版权所有 2006 上海悦闻信息技术有限公司
 */

package org.lua.web;

import org.lua.constant.Constant;

import java.util.HashMap;
import java.util.Map;

/**
 * 表格控件的搜索，分页，排序辅助类
 * 页面的表格控件发送参数到后台
 *
 * @author       $Author$
 * @version      $Revision$ $Date$
 */

public class PageParam {


	
	/**
	 * 请求类型是查询，分页或排序还是导出excel
	 * 1. list
	 * 2. export excel
	 */
	private String type = Constant.LIST_TYPE;
	
	/**
	 * 查询的内容
	 */
	private Map<PageSearchKey, Object> searchParamter = new HashMap<PageSearchKey, Object>();
	
	private Map<String, Object> search = new HashMap<String, Object>();
	
	private Map<String, String> exportParamter = new HashMap<String, String>();
	
	/**
	 * 查询页码
	 */
	private int pageNumber;
	
	/**
	 * 查询页大小
	 */
	private int pageSize;
	
	/**
	 * 排序
	 */
	private String sortString="id DESC";

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Map<PageSearchKey, Object> getSearchParamter() {
		return searchParamter;
	}

	public void setSearchParamter(Map<PageSearchKey, Object> searchParamter) {
		this.searchParamter = searchParamter;
	}
	
	public void clearSearchParamter() {
		this.searchParamter.clear();
	}
	
	public void addSearchParamter(PageSearchKey key, Object value) {
		this.searchParamter.put(key, value);
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getSortString() {
		return sortString;
	}

	public void setSortString(String sortString) {
		this.sortString = sortString;
	}

	public Map<String, Object> getSearch() {
		return search;
	}

	public void setSearch(Map<String, Object> search) {
		this.search = search;
	}

	public Map<String, String> getExportParamter() {
		return exportParamter;
	}

	public void setExportParamter(Map<String, String> exportParamter) {
		this.exportParamter = exportParamter;
	}
}
