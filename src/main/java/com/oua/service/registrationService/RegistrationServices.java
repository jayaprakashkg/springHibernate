package com.oua.service.registrationService;

import org.springframework.stereotype.Component;

import com.jai.Registration;



@Component
public interface RegistrationServices {

	public boolean registerNewAccount(Registration registration);
	public boolean verifyNewAccountRequest(Registration registration);
}
