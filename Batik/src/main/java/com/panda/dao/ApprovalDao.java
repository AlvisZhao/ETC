package com.panda.dao;

import java.util.List;

import com.panda.pojo.Approval;

public interface ApprovalDao {

	/**
	 * @category 通过需求计划编码查询所有审批信息
	 * @param requestPlanCode
	 * @return
	 */
	List<Approval> qureyByRequestCode(String requestPlanCode);
}
