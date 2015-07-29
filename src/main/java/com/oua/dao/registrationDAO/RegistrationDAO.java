package com.oua.dao.registrationDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.jai.PersistenceManager;
import com.oua.entity.RegistrationEntity;

@NamedQuery(
		  name="findAccountByMail",
		  query="Select account from Registratin account where account.mailid = :mailid"		  
		)

@Component
@Repository("registerDao")
public class RegistrationDAO {


	private static EntityManager em;
	
	public boolean registerNewAccount(RegistrationEntity registrationEntity)
	{		
		try
		{
			em = PersistenceManager.INSTANCE.getEntityManager();
			
		    em.getTransaction()
		        .begin();
		    em.persist(registrationEntity);
		    em.getTransaction()
		        .commit();
		 
		    em.close();
		    PersistenceManager.INSTANCE.close();
		    return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
	public List<RegistrationEntity> getRegistrationDetail(String emailId)
	{
		
		Query query = em.createNamedQuery("findAccountByMail");
		query.setParameter("email", emailId);
		List<RegistrationEntity> account = query.getResultList();
		return account;
		//Query query = em.createQuery("Select accounts from Registration accounts where accounts.address.city = :city");
		/*query.setParameter("city", "Ottawa");
		query.setHint("acme.jpa.batch", "emp.address");
		List<Employee> employees = query.getResultList();*/
	}
}
