package fr.imie.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.imie.spring.model.AjaxResponseModel;

@Controller
public class AjaxController {
		
	@ResponseBody
	@RequestMapping(name="/messages", method=RequestMethod.GET)
	public AjaxResponseModel<Object> getToutMessages() {
		AjaxResponseModel<Object> resp = new AjaxResponseModel<>();
		//TODO
		return resp;
	}
	
}
