package com.caps.dev.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.caps.dev.beans.Dog;
import com.caps.dev.dao.DogDAO;
import com.caps.dev.dao.DogJPAImpl;
import com.caps.dev.one.to.one.Address;
import com.caps.dev.one.to.one.Person_OneToOneUnidirectional;
import com.caps.dev.util.JPAUtils;

public class App 
{
	public static void main(String[] args) 
	{

		Person_OneToOneUnidirectional p = new Person_OneToOneUnidirectional();
		p.setName("Abhijit Kumar");
		p.setAge(23);
		p.setId(1);

		Address address = new Address();
		address.setCity("Bhubaneswar");
		address.setPin(560001);
		address.setState("Odisha");
		address.setAddress_id(101);
		p.setAddress(address);

		EntityManagerFactory emf = JPAUtils.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		//		em.persist(p);
		p = em.find(Person_OneToOneUnidirectional.class, 1);
		em.remove(p);
		em.getTransaction().commit();
		em.close();
		emf.close();

	}
}
