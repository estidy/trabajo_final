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
		model.addAttribute("title", title);
		model.addAttribute("text", text);
		return "login";
	}
}
