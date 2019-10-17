package com.caps.dev.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import com.caps.dev.beans.Movie;
import com.caps.dev.util.JPAUtils;

public class HibernateImpl implements MovieDAO {

	EntityManagerFactory emf = JPAUtils.getEntityManagerFactory();

	public boolean createMovie(Movie m) {
		EntityManager em = emf.createEntityManager();
		boolean state = false;
		em.getTransaction().begin();
		try {
			em.persist(m);
			state = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		em.getTransaction().commit();
		em.close();
		emf.close();
		return state;
	}

	public boolean deleteMovie(int movieId) {
		boolean state = false;
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		Movie m = em.find(Movie.class, movieId);
		transaction.begin();
		try {
			em.remove(m);
			state = true;
		} catch (Exception e) {
			e.printStackTrace();
			state = false;
		}
		transaction.commit();
		em.close();
		return state;
	}

	public boolean updateRatings(int movieId, int rating) {
		EntityManager em = emf.createEntityManager();
		boolean state = false;
		try {
			em.getTransaction().begin();
			Movie m = em.find(Movie.class, movieId);
			m.setRating(rating);
			em.getTransaction().commit();
			state = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return state;
	}

	public Movie searchById(int id) {
		EntityManager em = emf.createEntityManager();
		System.out.println("Ready to hit the DB");
		//		Movie m = em.find(Movie.class, id);
		Movie m = em.getReference(Movie.class, id);
		System.out.println(m);
		em.close();
		return m;
	}

}
