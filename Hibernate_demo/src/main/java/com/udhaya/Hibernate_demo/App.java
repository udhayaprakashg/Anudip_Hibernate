package com.udhaya.Hibernate_demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.udhaya.Hibernate_demo.config.HibernateUtil;
import com.udhaya.Hibernate_demo.entity.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	Student student = new Student(1,"udhaya","prkash","udh@gmail.com");
    	Student student1 = new Student(2,"ravi","shankar","rs@gmail.com");
    	Student student2 = new Student(3,"kathir","velan","kv@gmail.com");
    	
    	Transaction transaction = null;
    	
    	try(Session session=HibernateUtil.getSessionFactory().openSession()){
    		
    		//start at transaction
    		
    		transaction = session.beginTransaction();
    		
    		//Save the student objects
    	
    		session.save(student);
    		session.save(student1);
    		session.save(student2);
    		
    		// commit transaction
    		transaction.commit();
    		
    		
    	}
    	catch(Exception e) {
    		transaction.rollback();
    	}
    	
    	try(Session session = HibernateUtil.getSessionFactory().openSession()){
    		
    		List<Student>students = session.createQuery("from Student", Student.class).list();
    		
    		students.forEach(s->System.out.println(s.getFirstName()));
    	}
    	catch(Exception e) {
    		if(transaction != null) {
    			transaction.rollback();
    		}
    		e.printStackTrace();
    	}
        
        
    }
}
