package com.afo.main;

import java.util.List;

import com.afo.dao.CatalogueDaoImpl;
import com.afo.entity.Produit;
import com.afo.interf.IcatalogueDao;

public class JpaMainApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Produit p1 = new Produit("pantalon vert", 10.2, 4);
		Produit p2 = new Produit("Chaussure bleu", 5.2, 3);
		Produit p3 = new Produit("pantalon blanc", 15.2,1 );
		
		IcatalogueDao<Produit> dao = new CatalogueDaoImpl();
		dao.addProduit(p1);
		dao.addProduit(p2);
		dao.addProduit(p3);
		//dao.deleteProduit(new Long(1L));
		List<Produit> liste = dao.listProduits();
		System.out.println(liste);
		
		
		

	}

}
