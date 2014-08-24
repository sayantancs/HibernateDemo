package org.javabrains.sayantan.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javabrains.sayantan.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		UserDetails user = new UserDetails();
		/*
		user.setName("second user");
		user.setUserId(2);
		*/
		user.setName("first user");
		user.setUserId(1);
		user.setAddress("first user's address");
		user.setJoinDate(new Date());
		user.setDescriptionl("first user's description");

		@SuppressWarnings("deprecation")  				
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory(); 
		
		// Store
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();	
		session.close();
		
		user = null;
		// Retrieve
		session = sessionFactory.openSession();
		session.beginTransaction();
		user = (UserDetails) session.get(UserDetails.class, 1);	// 1 is primary key of the object to be retrieved
		System.out.println("Username retrieved is:" + user.getName());
		session.close();
	}

}
