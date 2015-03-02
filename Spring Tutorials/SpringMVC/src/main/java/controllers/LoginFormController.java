package controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import beans.Userform;

@Controller
public class LoginFormController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
    public String viewLogin(Model model) {
        Userform user = new Userform();
        model.addAttribute("userForm", user);
        return "loginform";
    }
	@RequestMapping(method=RequestMethod.POST, value="/login")
	public String login(@Valid @ModelAttribute("userForm") Userform form , BindingResult result){
		if(result.hasErrors()){
			return "loginform";
		}
		else{
			return "success";
		}
	}
}
