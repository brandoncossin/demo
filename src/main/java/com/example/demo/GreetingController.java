package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GreetingController {

	@GetMapping("/greeting")
	public String greetingForm(Model model) {
		model.addAttribute("greeting", new Greeting());
		System.out.println("printing");
		return "greeting";
	}

	@PostMapping("/greeting")
	public String greetingSubmit(@ModelAttribute Greeting greeting, Model model) {
		model.addAttribute("greeting", greeting);
		String name = greeting.getContent();
		System.out.println("printing" + name);
		return "greeting";
	}

	@GetMapping("/login")
	public String loginForm(Model model) {
		model.addAttribute("login", new Login());
		System.out.println("printing");
		return "login";
	}

	@PostMapping("/login")
	public String loginSubmit(@ModelAttribute Login login, Model model) {
		String name = login.getPhoneNumber();
		model.addAttribute("login", login);
		System.out.println("printing" + name);

		return "login";
	}
	@GetMapping("/signup")
	public String signupForm(Model model) {
		model.addAttribute("signup", new Signup());
		System.out.println("printing signup");
		return "signup";
	}
	@PostMapping("/signup")
	public String signupSubmit(@ModelAttribute Signup signup, Model model) {
		String name = signup.getFirstName();
		model.addAttribute("signup", signup);
		System.out.println("printing signup: " + name);
		return "signup";
	}
	
}