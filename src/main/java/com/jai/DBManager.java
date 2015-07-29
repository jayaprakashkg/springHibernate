package com.jai;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class DBManager {

	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;

	
	public static SessionFactory getSessionFactory() {
		if(sessionFactory == null)
		{
			Configuration configuration = new Configuration();
		    configuration.configure("hibernate.cfg.xml");
		    serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
		            configuration.getProperties()).build();
		    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		    return sessionFactory;
		}
		else
		{
			return sessionFactory;
		}	    
	}
}
