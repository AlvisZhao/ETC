package com.panda.service;

import java.util.List;

import com.panda.pojo.Approval;

public interface ApprovalService {

	/**
	 * @category 通过需求计划编码查询所有审批信息
	 * @param requestPlanCode
	 * @return
	 */
	List<Approval> qureyByRequestCode(String requestPlanCode);	
}
