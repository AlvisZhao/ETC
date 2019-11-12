package com.panda.dao;

import java.util.List;

import javax.annotation.Resource;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.panda.pojo.Purchase;

@Repository
public class PurchaseDaoImpl implements PurchaseDao{
	
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
	public List<Purchase> queryAll() {
		return getCurrentSession().createQuery("from " + Purchase.class.getName()).list();
	}

	public void updatePlanName(String planCode, String planName) {
		Session session = getCurrentSession();
		String hql = "update t_panda_purchase t  set t.purchasePlanName = '" 
		+ planName + "' where t.requestPlanCode = '" + planCode + "'";
		SQLQuery query =session.createSQLQuery(hql);
		query.executeUpdate();
	}

}
