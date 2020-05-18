package com.afo.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public abstract class AbstractDao<T> {
  
	public abstract EntityManager getEm();
	
	public void save(T entity) {
		// TODO Auto-generated method stub
				EntityTransaction  transaction = getEm().getTransaction();
				transaction.begin();
				
				try {
					getEm().persist(entity);
					transaction.commit();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					transaction.rollback();
					e.printStackTrace();
				}
				
	}
	
	public void update(Class<T> clazz, Long id) {
		T p = getEm().find(clazz, id);
		getEm().merge(p);		
	}
}
