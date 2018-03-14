/**
 *        (c) 2006 JOVEN
 *
 *        http://www.joven.com.cn
 */

package org.lua.service.process;

import com.schickit.utils.DateUtils;
import com.schickit.utils.StringUtils;
import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.impl.RepositoryServiceImpl;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.pvm.PvmTransition;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.lua.constant.Constant;
import org.lua.entity.ApprovalRecord;
import org.lua.entity.BaseEntity;
import org.lua.repository.base.BasePage;
import org.lua.service.configuration.UserRoleService;
import org.lua.service.configuration.UserService;
import org.lua.util.UserUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author $Author$
 * @version $Revision$ $Date$
 */
@Component
@Transactional(readOnly = true)
public class ProcessService {

	final Logger logger = LoggerFactory.getLogger(ProcessService.class);

	@Autowired
	ProcessEngine engine;

	@Autowired
    UserService userService;

	@Autowired
    UserRoleService userRoleService;

	@Autowired
	ApprovalRecordService approvalRecordService;

	@Transactional(readOnly = false)
	public String deploy(String entityName) {

		RepositoryService service = engine.getRepositoryService();

		if (null == entityName) {
			throw new RuntimeException(Constant.ERROR_WORK_FLOW_NAME_NOTNULL);
		}
		Deployment deployment = service.createDeployment().addClasspathResource("diagrams/" + entityName).deploy();
		ProcessDefinitionQuery pdq = service.createProcessDefinitionQuery().deploymentId(deployment.getId());
		logger.info("部署启动的工作流模板：" + pdq.list().get(0).getId());

		return pdq.list().get(0).getId();
	}

	@Transactional(readOnly = false)
	public String startProcess(BaseEntity entity, Map<String, Object> variables) {
		if (entity == null && entity.getId() == null) {
			throw new RuntimeException(Constant.ERROR_WORK_FLOW_BUSINESS_ID_NOTNULL);
		}

		IdentityService identityService = engine.getIdentityService();
		identityService.setAuthenticatedUserId(UserUtils.getCurrentUser().getUsername());
		// identityService.setAuthenticatedUserId(userService.findOne(1l).getUsername());
		logger.info("设置启动人");

		String entityName = entity.getClass().getSimpleName();

		String businessKey = entityName + "." + entity.getId();

		ProcessInstance pi = engine.getRuntimeService().startProcessInstanceByKey(entityName, businessKey, variables);// 使用流程定义ID开启一个流程
		logger.info("流程定义的ID：" + pi.getProcessDefinitionId());
		logger.info("流程实例的ID：" + pi.getId());
		return pi.getProcessInstanceId();

	}

	/**
	 * 执行某个流程节点
	 * 
	 * @param taskId
	 * @param variables
	 */
	@Transactional(readOnly = false)
	public void completeTask(String taskId, Map<String, Object> variables) {
		engine.getTaskService().complete(taskId, variables);
		logger.info("完成任务：" + taskId);
	}

	/**
	 * 签收任务
	 * 
	 * @param taskId
	 * @param username
	 */
	@Transactional(readOnly = false)
	public void claim(String taskId, String username) {
		Task task = engine.getTaskService().createTaskQuery().taskId(taskId).active().singleResult();
		engine.getTaskService().claim(taskId, username);
		logger.info("签收任务：" + taskId + " 签收人：" + username);
		ApprovalRecord approvalRecord = new ApprovalRecord(task.getName(), UserUtils.getCurrentUser(), DateUtils.getCurrentDateTime(), "签收", null, task.getId(), task.getProcessInstanceId());
		approvalRecordService.save(approvalRecord);
		logger.info("保存日志：" + task.getName());
	}

	@Transactional(readOnly = false)
	public Task findTaskByProcessInstanceId(String processInstanceId) {
		return engine.getTaskService().createTaskQuery().processInstanceId(processInstanceId).active().singleResult();
	}

	/**
	 * 通过taskId查找processInstanceId
	 * 
	 * @param taskId
	 * @return
	 */
	@Transactional(readOnly = false)
	public String getBusinessId(String taskId) {
		Task task = engine.getTaskService().createTaskQuery().taskId(taskId).singleResult();

		ProcessInstance pi = engine.getRuntimeService().createProcessInstanceQuery().processDefinitionId(task.getProcessInstanceId()).singleResult();

		return pi.getBusinessKey();
	}
	/*	*//**
			 * 所有待签收的任务
			 * 
			 * @return
			 *//*
			 * public List<Task> findTaskListByCurrentUser(){ User user =
			 * UserUtils.getCurrentUser(); List<String> roleNameList =
			 * userRoleService.findRoleNameListByUser(user.getId()); List<Task>
			 * userTaskList = findTaskListByUser(user.getUsername()); List<Task>
			 * userGroupTaskList = findTaskListInGroup(roleNameList); List<Task>
			 * ret = new ArrayList<Task>(); ret.addAll(userTaskList);
			 * ret.addAll(userGroupTaskList);
			 * 
			 * //按日期升序排序 Collections.sort(ret, new Comparator<Task>() {
			 * 
			 * public int compare(Task o1, Task o2) { return
			 * o1.getCreateTime().compareTo(o2.getCreateTime()); }
			 * 
			 * });
			 * 
			 * return ret;
			 * 
			 * }
			 */

	/*	*//**
			 * 得到经办人的待办
			 * 
			 * @param userId
			 * @return
			 *//*
			 * @Transactional(readOnly=true) public List<Task>
			 * findTaskListByAssignee(String userId) { List<Task> list =
			 * engine.getTaskService().createTaskQuery().taskAssignee(userId).
			 * list(); return list; }
			 */

	/**
	 * 已办任务列表
	 * 
	 * @param userId
	 * @param pageable
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<HistoricProcessInstance> findDoneTask(String userId, Pageable pageable) {
		List<HistoricProcessInstance> hpis = engine.getHistoryService().createHistoricProcessInstanceQuery().involvedUser(userId).unfinished().orderByProcessInstanceStartTime().desc().listPage(pageable.getOffset(), pageable.getPageSize());

		Long count = engine.getHistoryService().createHistoricProcessInstanceQuery().involvedUser(userId).count();

		BasePage<HistoricProcessInstance> p = new BasePage<HistoricProcessInstance>(pageable.getPageNumber(), pageable.getPageSize(), count, hpis, pageable.getSort());

		return p;
	}

	/**
	 * 办结任务列表
	 * 
	 * @param userId
	 * @param pageable
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<HistoricProcessInstance> findFinishedTask(String userId, Pageable pageable) {
		List<HistoricProcessInstance> hpis = engine.getHistoryService().createHistoricProcessInstanceQuery().involvedUser(userId).finished().orderByProcessInstanceEndTime().desc().listPage(pageable.getOffset(), pageable.getPageSize());

		Long count = engine.getHistoryService().createHistoricProcessInstanceQuery().involvedUser(userId).count();

		BasePage<HistoricProcessInstance> p = new BasePage<HistoricProcessInstance>(pageable.getPageNumber(), pageable.getPageSize(), count, hpis, pageable.getSort());

		return p;
	}

	/**
	 * 通过流程定义id找到buinesskey所对应的类名和实例id
	 * 
	 * @param processInstanceId
	 * @return
	 */
	public String[] findKeyByProcessInstanceId(String processInstanceId) {
		ProcessInstance singleResult = engine.getRuntimeService().createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();
		String businessKey = singleResult.getBusinessKey();
		String[] split = businessKey.split("\\.");
		return split;
	}

	public List<PvmTransition> findFlowByExec(Execution ex) {
		String processDefinitionId = engine.getHistoryService().createHistoricProcessInstanceQuery().processInstanceId(ex.getProcessInstanceId()).singleResult().getProcessDefinitionId();
		ProcessDefinitionEntity processDefinitionEntity = (ProcessDefinitionEntity) ((RepositoryServiceImpl) engine.getRepositoryService()).getDeployedProcessDefinition(processDefinitionId);
		List<ActivityImpl> activities = processDefinitionEntity.getActivities();
		String activitiId = ex.getActivityId();
		String id = null;
		List<PvmTransition> outgoingTransitions = new ArrayList<PvmTransition>();
		for (ActivityImpl activityImpl : activities) {
			id = activityImpl.getId();
			if (activitiId.equals(id)) {
				outgoingTransitions = activityImpl.getOutgoingTransitions();
				System.out.println("当前任务：" + activityImpl.getProperty("name"));
			}
		}
		return outgoingTransitions;
	}

	public String agreeOrReject(Execution ex) {
		String processDefinitionId = engine.getHistoryService().createHistoricProcessInstanceQuery().processInstanceId(ex.getProcessInstanceId()).singleResult().getProcessDefinitionId();
		ProcessDefinitionEntity processDefinitionEntity = (ProcessDefinitionEntity) ((RepositoryServiceImpl) engine.getRepositoryService()).getDeployedProcessDefinition(processDefinitionId);
		List<ActivityImpl> activities = processDefinitionEntity.getActivities();
		// 当前实例的执行到哪个节点
		String activitiId = ex.getActivityId();
		for (ActivityImpl activityImpl : activities) {
			if (activityImpl.getId().equals(activitiId)) {
				List<PvmTransition> outgoingTransitions = new ArrayList<PvmTransition>();
				outgoingTransitions = activityImpl.getOutgoingTransitions();
				for (PvmTransition pvmTransition : outgoingTransitions) {
					String name = pvmTransition.getProperty("name").toString();
					if (!StringUtils.isEmpty(name)) {
						return name;
					}
				}
			}
		}
		return "";
	}

	/**
	 * 根据processInstanceId完成任务并生成日志，并根据message来流程走向
	 * 
	 * @param processInstanceId
	 * @param message
	 * @param
	 */
	@Transactional(readOnly = false)
	public void completeTask(String processInstanceId, String message, String opinion) {
		Task task = engine.getTaskService().createTaskQuery().processInstanceId(processInstanceId).active().singleResult();
		logger.info("启动流程后获取当前任务：" + task.getId());
		Map<String, Object> var = new HashMap<String, Object>();
		var.put(Constant.ACTIVITI_MESSAGE, message);
		engine.getTaskService().complete(task.getId(), var);
		logger.info("完成任务：" + task.getName());
		ApprovalRecord approvalRecord = new ApprovalRecord(task.getName(), UserUtils.getCurrentUser(), DateUtils.getCurrentDateTime(), message, opinion, task.getId(), processInstanceId);
		approvalRecordService.save(approvalRecord);
		logger.info("保存日志：" + task.getName());
	}

	/**
	 * 根据processInstanceId获取出线
	 * 
	 * @return
	 */
	public List<String> getFlows(String processInstanceId) {
		Task task = engine.getTaskService().createTaskQuery().processInstanceId(processInstanceId).singleResult();
		ExecutionEntity execution = (ExecutionEntity) engine.getRuntimeService().createExecutionQuery().executionId(task.getExecutionId()).singleResult();
		String activitiId = execution.getActivityId();
		logger.info("根据taskid获取activitiId：" + activitiId);
		String processDefinitionId = engine.getHistoryService().createHistoricProcessInstanceQuery().processInstanceId(task.getProcessInstanceId()).singleResult().getProcessDefinitionId();
		ProcessDefinitionEntity processDefinitionEntity = (ProcessDefinitionEntity) ((RepositoryServiceImpl) engine.getRepositoryService()).getDeployedProcessDefinition(processDefinitionId);
		List<ActivityImpl> activities = processDefinitionEntity.getActivities();
		logger.info("根据processInstanceId获取本流程图的所有节点");
		List<PvmTransition> outgoingTransitions = new ArrayList<PvmTransition>();
		List<String> messageList = new ArrayList<String>();
		for (ActivityImpl activityImpl : activities) {
			if (activityImpl.getId().equals(activitiId)) {
				outgoingTransitions = activityImpl.getOutgoingTransitions();
				for (PvmTransition pvmTransition : outgoingTransitions) {
					messageList.add(pvmTransition.getProperty("name").toString());
				}
				logger.info("获取本节点的所有出线");
			}
		}
		return messageList;
	}

	/*	*//**
			 * 待我签收的任务
			 * 
			 * @param userId
			 * @return
			 *//*
			 * @Transactional(readOnly=true) public List<Task>
			 * findTaskListByUser(String userId) { List<Task> list =
			 * engine.getTaskService().createTaskQuery().taskCandidateUser(
			 * userId).list(); return list; }
			 */

	/*	*//**
			 * 待用户组签收的任务
			 * 
			 * @param groupId
			 * @return
			 *//*
			 * @Transactional(readOnly=true) public List<Task>
			 * findTaskListByGroup(String groupId) { List<Task> list =
			 * engine.getTaskService().createTaskQuery().taskCandidateGroup(
			 * groupId).list(); return list; }
			 */

	/*	*//**
			 * 待一组用户组签收的问题
			 * 
			 * @param groupIdList
			 * @return
			 *//*
			 * @Transactional(readOnly=true) public List<Task>
			 * findTaskListInGroup(List<String> groupIdList) { List<Task> list =
			 * engine.getTaskService().createTaskQuery().taskCandidateGroupIn(
			 * groupIdList).list(); return list; }
			 */

}
