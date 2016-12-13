package ua.com.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.com.library.service.TestService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HomeController {

	@Autowired
	private TestService testService;
	
	
	@RequestMapping(value={"/","/home"}, method=RequestMethod.GET)
	public String home(Model model, HttpServletRequest request,
			HttpServletResponse response){
		model.addAttribute("tests",testService.returnCoockie(request,response));
		
		
		return "home";
	}
	
	@RequestMapping("/loginpage")
	public String login() {
		return "loginpage";
	}
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String logout() {

		return "redirect:/";
	}

	@RequestMapping(value = "/home", method = RequestMethod.POST)
	public String loginprocesing(){
		return "redirect:/home";
	}

	
	
}