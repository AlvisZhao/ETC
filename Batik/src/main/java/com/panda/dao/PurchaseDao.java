package com.panda.dao;

import java.util.List;

import com.panda.pojo.Purchase;

public interface PurchaseDao {
	
	/**
	  * 查新所有信息
	 * @return
	 */
	List<Purchase> queryAll();

}
