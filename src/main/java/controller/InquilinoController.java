package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.Inquilino;

public class InquilinoController {
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("AlquielresJPAV2");

	/** 
	 * 
	 */
	public static List<Inquilino> findAll() {
		EntityManager em = entityManagerFactory.createEntityManager();

		Query q = em.createNativeQuery("SELECT * FROM inquilino;", Inquilino.class);
		List<Inquilino> l = (List<Inquilino>) q.getResultList();

		em.close();

		return l;
	}

	/**
	 * 
	 * @param o
	 */
	public static void update(Inquilino o) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(o);
		System.out.println("HECHO");
		em.getTransaction().commit();
		em.close();
	}

	/**
	 * 
	 * @param o
	 */
	public static void insert(Inquilino o) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(o);
		System.out.println("HECHO");
		em.getTransaction().commit();
		em.close();
	}

	/**
	 * 
	 * @param o
	 */
	public static void delete(Inquilino o) {
		System.out.println(o.toString());
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.merge(o));
		System.out.println("HECHO");
		em.getTransaction().commit();
		em.close();
	}
	
//	em.getTransaction().begin();
//
//	Inquilino inquilino = em.find(Inquilino.class, 1051); // Busca la entidad que deseas eliminar
//
//	em.remove(em.merge(inquilino)); // Fusiona y elimina la entidad
//
//	em.getTransaction().commit();
//	em.close();
	
	/**
	 * 
	 */
//	private static void eliminacionEntidad () {
//
//		EntityManager em = entityManagerFactory.createEntityManager();
//
//		TypedQuery<Fabricante> q = em.createQuery("SELECT f FROM Fabricante as f where f.cif = '12345678A'", Fabricante.class);
//		
//		Inquilino fabricantes = q.getResultList();
//		
//		em.getTransaction().begin();
//		for (Fabricante fabEnLista : fabricantes) {
//			em.remove(fabEnLista);
//		}
//		em.getTransaction().commit();
//		
//		
//		em.close();
//	}
}
