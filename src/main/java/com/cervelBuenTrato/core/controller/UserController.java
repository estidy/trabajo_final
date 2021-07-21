package com.cervelBuenTrato.core.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
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

	@GetMapping("/controlProfile")
	public String controlProfile(Model model, @AuthenticationPrincipal User user) {
		/* User user = ((MyUserPrincipal) this.getPrincipal()).getUser(); */
		var profiles = user.getAuthorities();
		if (profiles.size() > 1) {
			var title = "SelectRol";
			model.addAttribute("title", title);
			model.addAttribute("profiles", profiles);
			return "selectProfile";
		}
		var profile = profiles.stream().findFirst().get().getAuthority();
		if (profile.equals("ADMIN"))
			return "redirect:/users/homeADMIN";
		else if (profile.equals("VENDEDOR"))
			return "redirect:/users/homeVENDEDOR";
		else
			return "redirect:/users/homeUSER";
	}

	@GetMapping("/homeADMIN")
	public String homeADMIN(Model model, @AuthenticationPrincipal User user, HttpSession session) {
		var title = "HomeProfile";
		session.setAttribute("actualProfile", "ADMIN");
		model.addAttribute("title", title);
		model.addAttribute("profile", session.getAttribute("actualProfile"));
		return "homeADMIN";
	}

	@GetMapping("/homeVENDEDOR")
	public String homeVENDEDOR(Model model, @AuthenticationPrincipal User user, HttpSession session) {
		var title = "HomeProfile";
		session.setAttribute("actualProfile", "VENDEDOR");
		model.addAttribute("title", title);
		model.addAttribute("profile", session.getAttribute("actualProfile"));
		return "homeVENDEDOR";
	}

	@GetMapping("/homeUSER")
	public String homeUSER(Model model, @AuthenticationPrincipal User user, HttpSession session) {
		var title = "HomeProfile";
		session.setAttribute("actualProfile", "USER");
		model.addAttribute("title", title);
		model.addAttribute("profile", session.getAttribute("actualProfile"));
		return "homeUSER";
	}

	@GetMapping("/abm_users")
	public String index(Model model, HttpSession session) {
		var title = "ABM-Users";
		model.addAttribute("title", title);
		model.addAttribute("users", userService.findAll());
		model.addAttribute("profile", session.getAttribute("actualProfile"));
		return "abm_users";
	}

	@GetMapping("/addUser")
	public String addUser(Usr user, Model model, HttpSession session) {
		var title = "AddUser";
		model.addAttribute("title", title);
		model.addAttribute("profiles", profileService.findAll());
		model.addAttribute("profile", session.getAttribute("actualProfile"));
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
	public String editUser(Usr user, Model model, HttpSession session) {
		var title = "EditUser";
		user = userService.findById(user).get();
		model.addAttribute("title", title);
		model.addAttribute("profiles", profileService.findAll());
		model.addAttribute("profile", session.getAttribute("actualProfile"));
		model.addAttribute("usr", user);
		return "addUser";
	}

	@GetMapping("/deleteUser")
	public String deleteUser(Usr user) {
		userService.deleteById(user);
		return "redirect:/users/abm_users";
	}

}
