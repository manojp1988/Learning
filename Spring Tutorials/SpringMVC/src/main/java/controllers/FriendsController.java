package controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import beans.Person;

@Controller
public class FriendsController {

	@RequestMapping(method = RequestMethod.GET, value = "/friends")
	public String listofFriends(Model model) {
		List<String> friendsList = new ArrayList<String>();
		for (int i = 0; i < 5; i++) {
			friendsList.add(i + " :");
		}
		model.addAttribute("friends", friendsList);
		return "friends";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/Age")
	public String getAge(Model model, @RequestParam("age") int age) {
		List<String> friendsList = new ArrayList<String>();
		for (int i = 0; i < 5; i++) {
			friendsList.add(i + " :" + age);
		}
		model.addAttribute("friends", friendsList);
		return "friends";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/friends/{num}")
	public String oneFriends(Model model, @PathVariable int num) {
		List<String> friendsList = new ArrayList<String>();
		for (int i = 0; i < num; i++) {
			friendsList.add(i + " :");
		}
		model.addAttribute("friends", friendsList);
		return "friends";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/register")
	public String getAddUserForm() {
		return "register";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/register")
	public String addUserForm(Person person, Model model/*,RedirectAttributes redir*/) {
		System.out.println("Person=" +person.getFirstName());
		model.addAttribute("username","manoj" );
		//redir.addFlashAttribute("manoj", "manoj"); To pass variables across redirect.
		//return "redirect:friends";
		return "result";
	}

}
