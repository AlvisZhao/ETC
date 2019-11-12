package com.panda.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.panda.pojo.Purchase;
import com.panda.service.PurchaseService;
import com.panda.service.UserService;

@Controller
public class PurchaseController {
	
	 /**
     * @category 依赖注入 DI IOC
     */
    @Resource
    PurchaseService purchaseService;// @Resource注解 等价于 userService = new UserServiceImpl();
    
    /**
     * 查询所有数据
     * @param parameter
     * @param request
     * @param response
     * @param session
     * @return
     */
    @RequestMapping("/purchase/queryUpdate")
    public@ResponseBody String queryAll(HttpServletRequest request, HttpServletResponse response) {
    	response.setHeader("Access-Control-Allow-Origin", "*");// 解决跨域问题
    	System.out.print("已收到前端传来的请求，正在查询......");
    	List<Purchase> list = purchaseService.queryAll();
    	Map<String, Object> result = new HashMap<String, Object>();
		if (list == null || list.size() == 0) {
			result.put("message", "目前还没有任何商品，请先添加商品");
			result.put("status", "0");
			return JSON.toJSONString(result);
		}

		result.put("message", "查询成功");
		result.put("status", "1");
		result.put("data", list);
		return JSON.toJSONString(result);
    }
    	
    /**
     * @category 通过需求计划编码修改采购计划名称
     * @param parameter
     * @param request
     * @param response
     * @param session
     * @return
     */
    @RequestMapping("/purchase/updatePlanName")
    public@ResponseBody String updatePlanName(
    		@RequestParam Map<String, String> parameter, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
    	String planName = parameter.get("purchasePlanName");
    	String planCode = parameter.get("requestPlanCode");
    	
    	//查询目标对象
    	//Purchase purchase = purchaseService.findPurchaseById(planCode);
    	//重新赋值
    	//purchase.setPurchasePlanType(planName);
    	
    	//更新
    	//purchaseService.updatePlanName(purchase)
    	
    	System.out.print("已接收到前端传来的数据" + planCode + planName);
		purchaseService.updatePlanName(planCode, planName);
		Map<String, String> result = new HashedMap();
		result.put("message", "更新成功");
		result.put("status", "1");
		return JSON.toJSONString(result);
    }
}
