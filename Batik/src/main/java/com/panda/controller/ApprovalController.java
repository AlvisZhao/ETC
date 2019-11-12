package com.panda.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.panda.pojo.Approval;
import com.panda.pojo.PurchaseModify;
import com.panda.service.ApprovalService;

@Controller
public class ApprovalController {
	
	/**
     * @category 依赖注入 DI IOC
     */
	@Resource
	ApprovalService approvalService;
	
	@RequestMapping("/purchase/getApproval")
	public @ResponseBody String getModifyPurchase(
			@RequestParam Map<String, String> parameter,HttpServletRequest request, HttpServletResponse response) {
		String requestPlanCode = parameter.get("purchasePlanCode");
		System.out.println("已经拿到了前台传过来的采购计划编码：" + requestPlanCode + "正在查询...");
		List<Approval> list = approvalService.qureyByRequestCode(requestPlanCode);
		Map<String, Object> result = new HashMap<String, Object>();
		if (list == null || list.size() == 0) {
			result.put("message", "该计划仍处于审批流程中，请过段时间再来查询！");
			result.put("status", "0");
			return JSON.toJSONString(result);
		}
		result.put("message", "查询成功");
		result.put("status", "1");
		result.put("data", list);
		return JSON.toJSONString(result);
	}
}
