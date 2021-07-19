package com.cervelBuenTrato.core.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cervelBuenTrato.core.model.Profile;
import com.cervelBuenTrato.core.model.Usr;
import com.cervelBuenTrato.core.services.ProfileService;
import com.cervelBuenTrato.core.services.UserService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("users")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private ProfileService profileService;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@GetMapping("/homeProfile")
	public String homeProfile(Model model, @AuthenticationPrincipal Usr user) {
		var title = "HomeProfile";
		model.addAttribute("title", title);
		return "homeProfile";
	}

	@GetMapping("/abm_users")
	public String index(Model model) {
		var title = "ABM-Users";
		model.addAttribute("title", title);
		model.addAttribute("users", userService.findAll());
		return "abm_users";
	}

	@GetMapping("/addUser")
	public String addUser(Usr user, Model model) {
		var title = "AddUser";

		model.addAttribute("title", title);
		model.addAttribute("profiles", profileService.findAll());
		return ("addUser");
	}

	@PostMapping("/saveUser")
	public String saveUser(@Valid Usr user, Errors errors, Model model) {
		if (errors.hasErrors()) {
			if (userService.findByUsername(user.getUsername()))
				model.addAttribute("existUsername", true);
			if (userService.findByEmail(user.getEmail()))
				model.addAttribute("existEmail", true);
			model.addAttribute("profiles", profileService.findAll());
			return ("addUser");
		}
		var pass = user.getPassword();
		user.setPassword(passwordEncoder.encode(pass));
		userService.save(user);
		return "redirect:/users/abm_users";
	}

	@PostMapping("/saveNewUser")
	public String saveNewUser(@Valid Usr user, Errors errors, Model model) {
		if (errors.hasErrors()) {
			if (userService.findByUsername(user.getUsername()))
				model.addAttribute("existUsername", true);
			if (userService.findByEmail(user.getEmail()))
				model.addAttribute("existEmail", true);
			var text = "volver";
			var link = "/login";
			model.addAttribute("text", text);
			model.addAttribute("link", link);
			return "register";
		}
		var pass = user.getPassword();
		user.setPassword(passwordEncoder.encode(pass));
		Profile profile = profileService.findByName("USER");
		user.addUserProfile(profile);
		userService.save(user);
		return "redirect:/login";
	}

	@GetMapping("/editUser/{id_user}")
	public String editUser(Usr user, Model model) {
		var title = "EditUser";
		user = userService.findById(user).get();
		model.addAttribute("title", title);
		model.addAttribute("profiles", profileService.findAll());
		model.addAttribute("usr", user);

		return "addUser";
	}

	@GetMapping("/deleteUser")
	public String deleteUser(Usr user) {
		userService.deleteById(user);
		return "redirect:/users/abm_users";
	}

}
