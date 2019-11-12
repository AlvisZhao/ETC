package com.panda.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.panda.dao.PurchaseDao;
import com.panda.pojo.Purchase;

@Service
@Transactional
public class PurchaseServiceImpl implements PurchaseService{

	@Resource
	PurchaseDao purchaseDao;

	public List<Purchase> queryAll() {
		return purchaseDao.queryAll();
	}

	public void updatePlanName(String planCode, String planName) {
		purchaseDao.updatePlanName(planCode, planName);
	}
}
