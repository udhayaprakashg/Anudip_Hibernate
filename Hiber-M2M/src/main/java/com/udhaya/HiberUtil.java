package com.udhaya;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

public class HiberUtil {

	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		
		if(sessionFactory==null) {
			try {
				
				Configuration config = new Configuration();
				Properties pro = new Properties();
				
				pro.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
				pro.put(Environment.URL, "jdbc:mysql://localhost:3306/hibernate_demo");
				pro.put(Environment.USER, "root");
				pro.put(Environment.PASS, "9042");
				pro.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
				pro.put(Environment.SHOW_SQL, "true");
				pro.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
				pro.put(Environment.HBM2DDL_AUTO, "create-drop");
				
				config.setProperties(pro);
				
				config.addAnnotatedClass(Class1.class);
				config.addAnnotatedClass(Class2.class);
				
				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
				
				System.out.println("Service Registry was created");
				
				
				sessionFactory = config.buildSessionFactory(serviceRegistry);
				
				System.out.println("Session Factory was created");
				
				return sessionFactory;
	   	  
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
		return sessionFactory;
	
	}
}
