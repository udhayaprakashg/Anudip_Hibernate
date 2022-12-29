package com.udhaya;

import org.hibernate.Session;

/**
 * Hello world!
 *
 */
public class App 
{
    @SuppressWarnings("deprecation")
	public static void main( String[] args )
    {
        
    	Class1 c1 = new Class1("Udhaya");
    	Class1 c11 = new Class1("Prakash");
    	
    	Class2 c2 = new Class2("Thirukalukundram");
        Class2 c22 = new Class2("Chennai");
    	
    	
    	c1.addClass2(c2);
    	c2.addClass1(c1);
    	
    	c11.addClass2(c22);
    	c2.addClass1(c11);

    	Session session = HiberUtil.getSessionFactory().openSession();
    	
    	session.beginTransaction();
    	
    	session.save(c1);
    	session.save(c2);
    	
    	session.getTransaction().commit();
    }
}
