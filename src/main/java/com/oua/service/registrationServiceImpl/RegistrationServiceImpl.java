package com.oua.service.registrationServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jai.Registration;
import com.oua.dao.registrationDAO.RegistrationDAO;
import com.oua.dao.registrationDAO.RegistrationDAOHybernate;
import com.oua.entity.RegistrationEntity;
import com.oua.service.registrationService.RegistrationServices;


@Service("registrationServices")
public class RegistrationServiceImpl implements RegistrationServices{

	@Autowired
	RegistrationDAO registerDao;
	
	@Autowired
	RegistrationDAOHybernate registerDaoHybernate;
	
	@Override
	public boolean registerNewAccount(Registration registration) {
		
		RegistrationEntity registrationEntity = new RegistrationEntity();
		registrationEntity.setBirthday(registration.getBirthday());
		registrationEntity.setFname(registration.getFname());
		registrationEntity.setlName(registration.getLname());
		registrationEntity.setEmail(registration.getEmail());
		registrationEntity.setGender(registration.getGender());
		registrationEntity.setPass(registration.getPass());
		
		//using jpa
		//+registerDao.registerNewAccount(registrationEntity);
		
		//using Hybernate
		registerDaoHybernate.registerNewAccount(registrationEntity);
		return true;
	}

	@Override
	public boolean verifyNewAccountRequest(Registration registration) {
		// TODO Auto-generated method stub
		return false;
	}

}
