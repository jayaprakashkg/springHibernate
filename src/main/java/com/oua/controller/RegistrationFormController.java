package com.oua.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jai.Registration;
import com.oua.service.registrationService.RegistrationServices;

@Controller
public class RegistrationFormController {

	@Autowired 
	RegistrationServices registrationServices;
	
	@RequestMapping(value = "/home.action")
    public ModelAndView home() throws Exception {
            System.out.println(" from home.action");
            ModelAndView modelAndView = new ModelAndView("redirect:/registration.jsp");
            return modelAndView;
    }
    
	
	@RequestMapping(value = "/register.action")
	public String registerNewAccount(@ModelAttribute Registration registrationForm, Model model) {
 
		registrationServices.registerNewAccount(registrationForm);
		model.addAttribute("message", "registeredSuccessfully");
		return "registrationSuccess";
 
	}
		
	@RequestMapping(value = "/registerAjax.action")
	@ResponseBody
	public Map<String, Object> registerNewAccountAjax(@ModelAttribute Registration registrationForm, Model model) {
 
		Map<String, Object> map = new HashMap<String, Object>();
		registrationServices.registerNewAccount(registrationForm);
		map.put("message", "registeredSuccessfully");
		return map;
	}
}
