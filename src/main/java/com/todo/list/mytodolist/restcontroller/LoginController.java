package com.todo.list.mytodolist.restcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	
	@GetMapping("/todo/loginPage")
	public String showMyLoginPage() {
		
		return "login";
	}
	
	
	@GetMapping(value = "/")
    public String defaultPage(ModelMap map) {
        return "redirect:/todo/list";
    }
	@GetMapping("/todo/logout")
	public String logout()
	{
		return "logout";
	}
}
