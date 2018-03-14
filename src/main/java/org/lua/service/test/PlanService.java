package org.lua.service.test;

import org.lua.entity.test.Plan;
import org.lua.repository.test.PlanDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author AMGuo E-mail:www.guoao@foxmail.com
 * @version 创建时间：2017年3月24日 下午5:33:22 类说明
 */
@Component
@Transactional(readOnly = true)
public class PlanService {

	@Autowired
    PlanDao planDao;

	@Transactional(readOnly = false)
	public void save(Plan plan) {
		planDao.save(plan);
	}
}
