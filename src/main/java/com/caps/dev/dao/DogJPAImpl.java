package com.caps.dev.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.caps.dev.beans.Dog;
import com.caps.dev.util.JPAUtils;

public class DogJPAImpl implements DogDAO {
	EntityManagerFactory emf = JPAUtils.getEntityManagerFactory();

	public void createDogProfile(Dog d) {
		EntityManager em = emf.createEntityManager();
		boolean state = false;
		em.getTransaction().begin();
		em.persist(d);
		state = true ;
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

}
