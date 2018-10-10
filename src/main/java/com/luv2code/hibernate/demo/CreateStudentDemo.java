package com.luv2code.hibernate.demo;

import com.luv2code.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateStudentDemo {

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
			System.out.println("Creating new student object");
			Student tmpStudent = new Student("Naegele", "Stephan", "some@mail.com");
			// start a transaction
			System.out.println("Starting the transaction");
			session.beginTransaction();
			// save the student
			System.out.println("Saving the student object");
			session.save(tmpStudent);
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
