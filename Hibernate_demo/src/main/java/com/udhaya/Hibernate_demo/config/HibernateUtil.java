package com.udhaya.Hibernate_demo.config;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import com.udhaya.Hibernate_demo.entity.Student;


public class HibernateUtil {

	private static SessionFactory sessionFactory;//Interface
	
	public static SessionFactory getSessionFactory() {
		
		if(sessionFactory==null) {
			try {
				Configuration config = new Configuration();
				
				Properties sett = new Properties(); //This is mapping
				sett.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
				sett.put(Environment.URL, "jdbc:mysql://localhost:3306/hibernate_demo");
				sett.put(Environment.USER, "root");
				sett.put(Environment.PASS, "9042");
				
				sett.put(Environment.DIALECT,"org.hibernate.dialect.MySQL8Dialect");
				sett.put(Environment.SHOW_SQL,"true");
				sett.put(Environment.CURRENT_SESSION_CONTEXT_CLASS,"thread");
				sett.put(Environment.HBM2DDL_AUTO,"create-drop");
				config.setProperties(sett);
				
				config.addAnnotatedClass(Student.class);
				
				config.setProperties(sett); //Added all properties to config
				
				StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						    .applySettings(config.getProperties()).build();
				//If table is not null it will drop the table
				
				sessionFactory = config.buildSessionFactory(serviceRegistry);}
			catch(Exception e) {
				e.printStackTrace();}
		     }
		return sessionFactory;
	}
}
