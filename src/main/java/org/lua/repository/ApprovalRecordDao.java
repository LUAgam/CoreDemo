package org.lua.repository;

import org.lua.entity.ApprovalRecord;
import org.lua.repository.base.BaseRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/** 
* @author AMGuo E-mail:www.guoao@foxmail.com 
* @version 创建时间：2017年3月27日 上午11:38:04 
* 类说明 
*/
public interface ApprovalRecordDao extends BaseRepository<ApprovalRecord, Long>, JpaSpecificationExecutor<ApprovalRecord> {

	ApprovalRecord findByTaskId(String taskId);

	List<ApprovalRecord> findByProcessInstanceId(String processInstanceId);

}
