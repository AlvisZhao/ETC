package com.panda.service;
import java.util.List;

import com.panda.pojo.Purchase;

public interface PurchaseService {

	/**
	  *   查询所有信息
	 * @return
	 */
	List<Purchase> queryAll();
	
	
}
