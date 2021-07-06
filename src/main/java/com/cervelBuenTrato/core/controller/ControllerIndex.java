package com.cervelBuenTrato.core.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cervelBuenTrato.core.model.User;
import com.cervelBuenTrato.core.services.RepositoryService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ControllerIndex {
	@Autowired
	private RepositoryService userService;

	@GetMapping("/")
	public String index(Model model) {
		var title = "Home";
		var users = userService.findAll();
		model.addAttribute("title", title);
		model.addAttribute("users", users);
		return "index";
	}

	@GetMapping("/addUser")
	public String addUser(User user, Model model) {
		var title = "AddUser";
		model.addAttribute("title", title);
		return ("addUser");
	}

	@PostMapping("/saveUser")
	public String saveUser(@Valid User user, Errors errors) {
		if (errors.hasErrors())
			return ("addUser");
		userService.save(user);
		return "redirect:/";
	}

	@GetMapping("/editUser/{id}")
	public String editUser(User user, Model model) {
		var title = "EditUser";
		model.addAttribute("title", title);
		user = userService.findById(user).get();
		model.addAttribute("user", user);
		return "addUser";
	}

	@GetMapping("/deleteUser")
	public String deleteUser(User user) {
		userService.deleteById(user);
		return "redirect:/";
	}
}
