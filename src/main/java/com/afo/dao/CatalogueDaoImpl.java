package com.afo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.afo.entity.AbstractDao;
import com.afo.entity.Produit;
import com.afo.interf.IcatalogueDao;

public class CatalogueDaoImpl  implements IcatalogueDao<Produit> {

	private EntityManager entityManager;
	
	public CatalogueDaoImpl() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("UP_CAT");
		entityManager = entityManagerFactory.createEntityManager();
	}
	
	public void addProduit(Produit p) {
		save(p);
				
	}

	public List<Produit> listProduits() {
		Query query = entityManager.createQuery("select p from Produit p");
		return query.getResultList();
	}

	public List<Produit> listProduitsParMC(String mc) {
		// TODO Auto-generated method stub
		Query query = entityManager.createQuery("select p from Produit p where p.designation like :x");
		query.setParameter("x", "%"+mc+"%");
		return query.getResultList();
	}

	public Produit getProduit(Long idProduit) {
		// TODO Auto-generated method stub
		Produit p = entityManager.find(Produit.class, idProduit);
		return p;
	}

	public void updateProduit(Produit p) {
		// TODO Auto-generated method stub
		entityManager.merge(p);
		
	}

	public void deleteProduit(Long idp) {
		// TODO Auto-generated method stub
		entityManager.remove(idp);
		
	}
	
	
//	public void update(Long id) {
//		update(Produit.class, id);
//	}

	@Override
	public EntityManager getEm() {
		// TODO Auto-generated method stub
		return entityManager;
	}

}
