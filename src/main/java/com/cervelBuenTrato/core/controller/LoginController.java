package com.cervelBuenTrato.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/login")
	public String login(Model model) {
		var title = "Login";
		var text = "Registrarse";
		var link = "/register";
		model.addAttribute("title", title);
		model.addAttribute("text", text);
		model.addAttribute("link", link);
		return "login";
	}
}
