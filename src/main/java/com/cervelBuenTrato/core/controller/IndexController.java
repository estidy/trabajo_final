package com.cervelBuenTrato.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cervelBuenTrato.core.model.Usr;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping
public class IndexController {

	@GetMapping("/")
	public String index(Model model) {
		var title = "Home";
		var text = "Ingresar";
		var link = "/login";
		model.addAttribute("title", title);
		model.addAttribute("text", text);
		model.addAttribute("link", link);
		return "index";
	}

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

	@GetMapping("/loginError")
	public String loginError(Model model) {
		var title = "LoginError";
		var text = "Volver";
		var link = "/login";
		model.addAttribute("title", title);
		model.addAttribute("text", text);
		model.addAttribute("link", link);
		return "/templates_errors/403";
	}

	@GetMapping("/register")
	public String register(Usr user, Model model) {
		var title = "Registrarse";
		var text = "Volver";
		var link = "/login";
		model.addAttribute("title", title);
		model.addAttribute("text", text);
		model.addAttribute("link", link);
		return "register";
	}

}
