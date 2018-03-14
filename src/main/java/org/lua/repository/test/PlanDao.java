package org.lua.repository.test;

import org.lua.entity.test.Plan;
import org.lua.repository.base.BaseRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/** 
* @author AMGuo E-mail:www.guoao@foxmail.com 
* @version 创建时间：2017年3月24日 下午5:34:11 
* 类说明 
*/
public interface PlanDao extends BaseRepository<Plan, Long>, JpaSpecificationExecutor<Plan> {

}
