package com.udhaya.Hibernate_demo.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.udhaya.Hibernate_demo.config.HibernateUtil;
import com.udhaya.Hibernate_demo.entity.Student;

public class StudentDao {
	
	public void getStduent(int id) {
		Transaction transaction = null; //Implementation of JDBC
		
		try(Session session=HibernateUtil.getSessionFactory().openSession()){
			
			//Start the session
			transaction = session.beginTransaction();
			
			//get Student entity using get() method
			
			Student student = session.get(Student.class, id);
			System.out.println(student.getFirstName());
			System.out.println(student.getEmail());
			
			//Commit transaction
			transaction.commit();}
		catch(Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();}
		
	}
	
	public void loadStudent(int id) {
		Transaction transaction = null;
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			
			//Start
			transaction = session.beginTransaction();
			
			//get student entity using load() method
			
			Student student = session.load(Student.class, id);
			System.out.println(student.getFirstName());
			System.out.println(student.getEmail());
			
			//commit
			transaction.commit();
		}
		catch(Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();}
		
	}
	
	public void getStudentById(int id) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
		// start a transaction
		transaction = session.beginTransaction();
		
		// Obtain an entity using byId() method
		Student student = session.byId(Student.class).getReference(id);
		System.out.println(student.getFirstName());
		System.out.println(student.getEmail());
		
		// commit transaction
		transaction.commit();
		} 
		catch (Exception e) {
		if (transaction != null) {
		transaction.rollback(); }
		e.printStackTrace(); }
	}
		
	
	public void saveStudent(Student student) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
		// start a transaction
		transaction = session.beginTransaction();
		
		// save the student object
		session.save(student);
		
		// commit transaction
		transaction.commit();
		} 
		catch (Exception e) {
		if (transaction != null) {
		transaction.rollback(); }
		e.printStackTrace(); }
		}
		
	}

