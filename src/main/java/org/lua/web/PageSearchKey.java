/**
 *        (c) 2006 Joven 
 *
 *        http://www.joven.com.cn
 *        版权所有 2006 上海悦闻信息技术有限公司
 */

package org.lua.web;



/**
 * 查询的辅助类
 *
 * @author       $Author$
 * @version      $Revision$ $Date$
 */

public class PageSearchKey {
	
	public static final String LIKE = "LIKE";
	public static final String NOT_LIKE = "NOT LIKE";
	public static final String EQ = "=";
	public static final String BIGERTHAN = ">";
	public static final String THINTHAN = "<";
	public static final String BIGERTHAN_EQ = ">=";
	public static final String THINTHAN_EQ = "<=";
	
	public static final String TEXT = "TEXT";
	public static final String DATE = "DATE";
	public static final String DATERNAGE = "DATERANGE";
	public static final String OPTIONS = "OPTIONS";
	public static final String OPTIONSENTITY = "OPTIONSENTITY";
	
	/**
	 * 字段名称
	 */
	private String searchKey;
	
	/**
	 * 字段类型
	 */
	private String type;
	
	/**
	 * 操作符号
	 */
	private String searchOperat;
	
	/**
	 * 搜索的值
	 */
	private String searchValue;

	public String getSearchKey() {
		return searchKey;
	}

	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}

	public String getSearchOperat() {
		return searchOperat;
	}

	public void setSearchOperat(String searchOperat) {
		this.searchOperat = searchOperat;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSearchValue() {
		return searchValue;
	}

	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((searchKey == null) ? 0 : searchKey.hashCode());
		result = prime * result + ((searchOperat == null) ? 0 : searchOperat.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PageSearchKey other = (PageSearchKey) obj;
		if (searchKey == null) {
			if (other.searchKey != null)
				return false;
		} else if (!searchKey.equals(other.searchKey))
			return false;
		if (searchOperat == null) {
			if (other.searchOperat != null)
				return false;
		} else if (!searchOperat.equals(other.searchOperat))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	/**
	 * 给出一个操作名称，得到HQL中相应的操作符(可以添加补充)
	 */
	public static String getOperatByName(String name) {
		if (LIKE.equals(name)) {
			return LIKE;
		} else if (EQ.equals(name)) {
			return EQ;
		} else if (BIGERTHAN.equals(name)) {
			return BIGERTHAN;
		} else if (BIGERTHAN_EQ.equals(name)) {
			return BIGERTHAN_EQ;
		} else if (THINTHAN.equals(name)) {
			return THINTHAN;
		} else if (THINTHAN_EQ.equals(name)) {
			return THINTHAN_EQ;
		} else if (NOT_LIKE.equals(name)) {
			return NOT_LIKE;
		}
		throw new RuntimeException("所给的操作符不在操作符常量中！");
	}
	
	/**
	 * 给出一个操作名称，得到HQL中相应的操作符(可以添加补充)
	 */
	public static String getTypeByName(String name) {
		if (TEXT.equals(name)) {
			return TEXT;
		} else if (DATERNAGE.equals(name)) {
			return DATERNAGE;
		} else if (DATE.equals(DATE)) {
			return DATE;
		} else if (OPTIONS.equals(OPTIONS)) {
			return OPTIONS;
		}
		throw new RuntimeException("所给的搜索类型不在类型常量中！");
	}
	
}
