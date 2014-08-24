package org.javabrains.sayantan.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javabrains.sayantan.dto.Address;
import org.javabrains.sayantan.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		UserDetails user = new UserDetails();
		UserDetails user2 = new UserDetails();
		/*
		user.setName("second user");
		user.setUserId(2);
		*/
		user.setName("first user");
		//user.setUserId(1);
		//user.setAddress("first user's address");
		user.setJoinDate(new Date());
		user.setDescriptionl("first user's description");
		
		user2.setName("second user");
		//user.setUserId(1);
		//user2.setAddress("second user's address");
		user2.setJoinDate(new Date());
		user2.setDescriptionl("second user's description");

		Address addr = new Address();
		addr.setStreet("street name");
		addr.setCity("kolkata");
		addr.setState("wb");
		addr.setPincode("700110");
		
		// adding another object in a field
		user.setAddress(addr);
		user2.setAddress(addr);
		
		
		@SuppressWarnings("deprecation")  				
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory(); 
		
		// Store
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.save(user2);
		session.getTransaction().commit();	
		session.close();
		
		
		// Retrieve from database with ORM
		/*
		user = null;
		session = sessionFactory.openSession();
		session.beginTransaction();
		user = (UserDetails) session.get(UserDetails.class, 1);	// 1 is primary key of the object to be retrieved
		System.out.println("Username retrieved is:" + user.getName());
		session.close();
		*/
	}

}
