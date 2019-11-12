package com.panda.service;
import java.util.List;

import com.panda.pojo.Purchase;

public interface PurchaseService {

	/**
	  *   查询所有信息
	 * @return
	 */
	List<Purchase> queryAll();
	
	/**
	 * 更新采购计划中的需求计划名称
	 * @param planCode
	 * @param planName
	 */
	void updatePlanName(String planCode, String planName);
}
