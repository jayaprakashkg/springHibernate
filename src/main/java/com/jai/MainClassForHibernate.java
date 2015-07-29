package com.jai;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class MainClassForHibernate {
  
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
	
public static void main(String[] args) {
	  
    /*Address address = new Address();
    //address.setId(3)
    address.setCity("Dhaka")
        .setCountry("Bangladesh")
        .setPostcode("1000")
        .setStreet("Poribagh");
 
    EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
    em.getTransaction()
        .begin();
    em.persist(address);
    em.getTransaction()
        .commit();
 
    em.close();
    PersistenceManager.INSTANCE.close();*/
	  try
	  {
		  Configuration cfg=new Configuration();
	      cfg.configure("hibernate.cfg.xml");
	      
	      Session session = getSessionFactory().openSession();
	      Product p=new Product();

	     // p.setProductId(105);
	      p.setProName("testing");
	      p.setPrice(15000);

	      Transaction tx = session.beginTransaction();
	      session.save(p);
	      System.out.println("Object saved successfully using annotations.....!!");
	      tx.commit();
	      session.close();	        
	  }
	  catch(Exception e)
	  {
		  e.printStackTrace();
	  }
	  
  }
}
