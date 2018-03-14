package org.lua.web.test.formbean;

import org.lua.annotation.Show;
import org.lua.web.BaseFormBean;

/**
 * @author AMGuo E-mail:www.guoao@foxmail.com
 * @version 创建时间：2017年3月27日 下午12:13:47 类说明
 */
public class PlanFB extends BaseFormBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8559571004574487022L;

	@Show(title="计划名称", pos=1)
	private String name;

	@Show(title="创建日期", pos=3)
	private String createDate;

	@Show(title="状态", pos=2)
	private String status;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
