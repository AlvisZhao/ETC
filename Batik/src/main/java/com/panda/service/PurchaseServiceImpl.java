package com.panda.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.panda.dao.PurchaseDao;

@Service
@Transactional
public class PurchaseServiceImpl implements PurchaseService{

	@Resource
	PurchaseDao purchaseDao;
}
