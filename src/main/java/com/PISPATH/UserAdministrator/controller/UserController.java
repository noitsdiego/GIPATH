package com.PISPATH.UserAdministrator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.PISPATH.UserAdministrator.model.UserModel;
import com.PISPATH.UserAdministrator.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;

    @GetMapping("/register")
    public String getRegisterPage(Model model){
    	model.addAttribute("registerRequest", new UserModel());
        return "registerUser";
    }

    @GetMapping("/comingSoon")
    public String getcomingSoon(Model model){
    	model.addAttribute("comingSoon", new UserModel());
        return "comingSoon";
    }
    
    @GetMapping("/login")
    public String getLoginPage(Model model){
    	model.addAttribute("loginRequest", new UserModel());
        return "loginUser";
    }
    
    @GetMapping("/loginIncorrect")
    public String getLoginIncorrectPage(){
        return "loginIncorrect";
    }
    
    @GetMapping("/registerIncorrect")
    public String getRegisterIncorrect(){
        return "registerIncorrect";
    }
    
    @GetMapping("/profilePage")
    public String getprofilePage(){
        return "profilePage";
    }
    
    @PostMapping("/registerUser")
    public void register(@ModelAttribute("registerRequest") UserModel userModel) {
        System.out.println("User: " + userModel.toString());
    }
    
    @PostMapping("/loggeo")
    public String loggeo(
            @RequestParam String emailUser,
            @RequestParam String passwUser, Model model) {
    	
    	
    	UserModel u = userService.obtenerUsuario(emailUser, passwUser);
    	
    	if(u != null) {
    		
    		model.addAttribute("user", u);
        	
        	
            return "perfil"; 
    	}else {
    		return "loginIncorrect";
    	}
    	
    	
    	
    	
    }
    
    @PostMapping("/registrarse")
    public String registrarse(
            @RequestParam String nameUser,
            @RequestParam String lastNameUser,
            @RequestParam String emailUser,
            @RequestParam String passwUser,
            @RequestParam String telUser,
            @RequestParam String cityUser,
            @RequestParam String countryUser) {
    	
        	UserModel user = new UserModel(nameUser, lastNameUser, emailUser, passwUser, telUser, cityUser, countryUser);
            return "redirect:/login"; 
        	
        	
    	
    	
    }

}
