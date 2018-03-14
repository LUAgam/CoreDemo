package org.lua.service.process;

import org.lua.entity.ApprovalRecord;
import org.lua.repository.ApprovalRecordDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/** 
* @author AMGuo E-mail:www.guoao@foxmail.com 
* @version 创建时间：2017年3月27日 上午11:35:25 
* 类说明 
*/
@Component
@Transactional(readOnly = true)
public class ApprovalRecordService {

	@Autowired
    ApprovalRecordDao approvalRecordDao;

	@Transactional(readOnly = false)
	public void save(ApprovalRecord approvalRecord) {
		approvalRecordDao.save(approvalRecord);
	}

	public ApprovalRecord findByTaskId(String taskId) {
		return approvalRecordDao.findByTaskId(taskId);
	}

	public List<ApprovalRecord> findByProcessInstanceId(String processInstanceId) {
		return approvalRecordDao.findByProcessInstanceId(processInstanceId);
	}
}
