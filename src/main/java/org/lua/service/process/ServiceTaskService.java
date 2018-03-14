package org.lua.service.process;

import org.activiti.engine.runtime.Execution;
import org.lua.entity.BaseEntity;
import org.lua.entity.StateMachine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * ServiceTask更新实例状态等信息
 * @author AMGuo E-mail:www.guoao@foxmail.com
 * @version 创建时间：2017年3月24日 下午2:42:17 类说明
 */
@Component
@Transactional(readOnly = true)
public class ServiceTaskService {

	@Autowired
	ProcessService processService;
	
	@Autowired
	GeneralEntityService generalEntityService;

	public void doService(Execution ex) {
		String agreeOrReject = processService.agreeOrReject(ex);
		String instanceId = ex.getProcessInstanceId();
		String[] buinessKey = processService.findKeyByProcessInstanceId(instanceId);
		@SuppressWarnings("rawtypes")
		BaseEntity baseEntity = generalEntityService.findOne(buinessKey);
		if(baseEntity instanceof StateMachine)
			baseEntity = ((StateMachine) baseEntity).doAction(agreeOrReject);
		generalEntityService.save(baseEntity);
	}
}
