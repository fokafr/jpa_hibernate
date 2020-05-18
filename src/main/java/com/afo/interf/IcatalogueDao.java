package com.afo.interf;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.afo.entity.Produit;

public interface IcatalogueDao<T> {
	public void addProduit(Produit p);

	public List<Produit> listProduits();

	public List<Produit> listProduitsParMC(String mc);

	public Produit getProduit(Long idProduit);

	public void updateProduit(Produit p);

	public void deleteProduit(Long idp);

	EntityManager getEm();

	default void save(T entity) {
		EntityTransaction transaction = getEm().getTransaction();
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
}
