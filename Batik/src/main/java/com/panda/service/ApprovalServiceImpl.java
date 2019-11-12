package com.panda.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.panda.dao.ApprovalDao;
import com.panda.pojo.Approval;

@Service
@Transactional
public class ApprovalServiceImpl implements ApprovalService{

	@Resource
	ApprovalDao approvalDao;
	
	public List<Approval> qureyByRequestCode(String requestPlanCode) {
		return approvalDao.qureyByRequestCode(requestPlanCode);
	}

}
