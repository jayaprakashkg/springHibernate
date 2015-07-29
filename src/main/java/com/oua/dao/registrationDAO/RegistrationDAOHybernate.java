package com.oua.dao.registrationDAO;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.jai.DBManager;
import com.oua.entity.RegistrationEntity;

@Component
@Repository("registerDaoHybernate")
public class RegistrationDAOHybernate {

	public boolean registerNewAccount(RegistrationEntity registrationEntity)
	{		
		try
		  {
			  /*Configuration cfg=new Configuration();
		      cfg.configure("hibernate.cfg.xml");*/
		      
		      Session session = DBManager.getSessionFactory().openSession();

		      Transaction tx = session.beginTransaction();
		      session.save(registrationEntity);
		      System.out.println("Object saved successfully using annotations.....!!");
		      tx.commit();
		      session.close();	        
		  }
		  catch(Exception e)
		  {
			  e.printStackTrace();
		  }
		return true;
	}
}
