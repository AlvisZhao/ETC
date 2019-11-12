package com.panda.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.panda.pojo.Approval;
import com.panda.pojo.PurchaseModify;

@Repository
public class ApprovalDaoImpl implements ApprovalDao{
	
	@Resource
	SessionFactory sessionFactory;
	
	/**
	 * @category 获取当前的session
	 * @return
	 */
	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public List<Approval> qureyByRequestCode(String requestPlanCode) {
		return getCurrentSession().createQuery(
                "from " + Approval.class.getName() + " where requestPlanCode='" + requestPlanCode + "'").list();
	}

	

}
