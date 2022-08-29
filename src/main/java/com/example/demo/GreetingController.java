package com.example.demo;

import java.sql.SQLException;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GreetingController {

	Database db = new Database();

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
	public String loginSubmit(@ModelAttribute Login login, Model model) throws SQLException {
		String username = login.getPhoneNumber();
		String password = login.getPassword();
		model.addAttribute("login", login);
		db.login(username, password);
		return "login";
	}
	@GetMapping("/signup")
	public String signupForm(Model model) {
		model.addAttribute("signup", new Signup());
		System.out.println("printing signup");
		return "signup";
	}
	@PostMapping("/signup")
	public String signupSubmit(@ModelAttribute Signup signup, Model model) throws SQLException {
		String phonenumber = signup.getPhoneNumber();
		String first_name = signup.getFirstName();
		String last_name = signup.getLastName();
		String password = signup.getPassword();
		String hashed_password = BCrypt.hashpw(password, BCrypt.gensalt()).toString();
		model.addAttribute("signup", signup);
		db.Insert(phonenumber, first_name, last_name, hashed_password);
		return "signup";
	}
	
}