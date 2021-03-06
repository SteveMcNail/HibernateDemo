package com.luv2code.demo;

import com.luv2code.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {
	public static void main(String[] args) {
		// create SessionFactory
		System.out.println("Creating SessionFactory");
		SessionFactory sessionFactory = new Configuration()
				                                .configure("hibernate.cfg.xml")
				                                .addAnnotatedClass(Student.class)
				                                .buildSessionFactory();

		// create Session
		System.out.println("Creating Session");
		Session session = sessionFactory.getCurrentSession();

		try {
			// use the session to save the student

			// create the student-object
			System.out.println("Creating 3 new student object");
			Student tmpStudent1 = new Student("Appleboom", "Mary", "Mary@mail.com");
			Student tmpStudent2 = new Student("Melonkin", "whatsdat", "whatsdat@mail.com");
			Student tmpStudent3 = new Student("Bonia", "whoisdat", "whoisdat@mail.com");
			// start a transaction
			System.out.println("Starting the transaction");
			session.beginTransaction();
			// save the student
			System.out.println("Saving the student object");
			session.save(tmpStudent1);
			session.save(tmpStudent2);
			session.save(tmpStudent3);
			// commit the transaction
			System.out.println("Committing the session");
			session.getTransaction().commit();

			System.out.println("done!");
		}
		finally {
			System.out.println("closing the Session Factory!");
			sessionFactory.close();
		}
	}
}
