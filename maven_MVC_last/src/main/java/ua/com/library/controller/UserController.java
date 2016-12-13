package ua.com.library.controller;

import java.security.Principal;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import editor.GroupsEditor;
import editor.TestEditor;
import ua.com.library.dto.DtoUtilMapper;
import ua.com.library.entity.Groups;
import ua.com.library.entity.Test;
import ua.com.library.entity.User;
import ua.com.library.service.GroupsService;
import ua.com.library.service.MailSenderService;
import ua.com.library.service.TestService;
import ua.com.library.service.UserService;
import ua.com.library.serviceImpl.UserServiceImp;

@Controller
public class UserController {
@Autowired
private UserService userService;

@Autowired
private GroupsService groupsService;
@Autowired
private TestService testService;
@Autowired
private MailSenderService mailSenderService;

@InitBinder
public void InitBinder(WebDataBinder binder){
           binder.registerCustomEditor(Groups.class, new GroupsEditor(groupsService));
}


@RequestMapping(value = "/signUp",method=RequestMethod.GET )
public String newUser(Model model){
	
	model.addAttribute("users", DtoUtilMapper.usersToUserDtop(userService.findAll()));
	model.addAttribute("groups", groupsService.getAll());
	model.addAttribute("user", new  User());
	
	
	return "signUp";
}



@RequestMapping(value="/saveUser", method=RequestMethod.POST)
public String click(@RequestParam String username, @RequestParam String phone,  @RequestParam String email, @RequestParam String password, @RequestParam String groupsId)
{
	
	User user= new User(username, phone, email, password);
	userService.addUsertoGroups(user, Integer.parseInt(groupsId));

	return "redirect:/signUp";
	
}	



@RequestMapping(value="/saveNewUser", method=RequestMethod.POST)
public String click(@ModelAttribute User user, Model model)
{
		String uuid = UUID.randomUUID().toString();
		user.setUUID(uuid);

	try {
		userService.save(user);
	} catch (Exception e) {
		
		model.addAttribute("exception", e.getMessage());
		return "signUp";
	}

	String theme="thank's for registration";
	String message ="gl & hl http://localhost:8080/Spring_Mvc_Continue/confirm/"+uuid;
	
	mailSenderService.sendMail(theme, message, user.getEmail());
	
	
	
	return "redirect:/signUp";
	
}

@RequestMapping(value ="/confirm/{uuid}",  method = RequestMethod.GET)
public String confirm(@PathVariable String uuid){
	User user = userService.findByUUID(uuid);
	user.setEnabled(true);
	userService.update(user);
	return "redirect:/";
}



@RequestMapping(value = "/deleteUsers/{id}", method = RequestMethod.GET)
public String newBook(@PathVariable int id) {

	userService.delete(id);
	
	return "redirect:/signUp";
}
@RequestMapping(value = "/saveImage", method = RequestMethod.POST)
public String saveImage(Principal principal, @RequestParam MultipartFile image){
	userService.saveImage(principal,image);
	return "redirect:/profile";
}
	
@RequestMapping(value = "/profile", method = RequestMethod.GET)
public String profile(Principal principal, Model model) {

	System.out.println(principal.getName());

	User user = userService.findUserTest(Integer.parseInt(principal.getName()));
	
	model.addAttribute("user", user);

	return "/profile";
}


}
