package com.cervelBuenTrato.core.controller;

import java.time.LocalDate;

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
import org.springframework.web.bind.annotation.RequestParam;

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
		if (session.getAttribute("actualProfile") == null)
			session.setAttribute("actualProfile", "ADMIN");
		if (session.getAttribute("menu") == null)
			session.setAttribute("menu", "fragments/menuAdmin.html");
		model.addAttribute("title", title);
		model.addAttribute("profile", session.getAttribute("actualProfile"));
		model.addAttribute("menu", session.getAttribute("menu"));
		return "homeADMIN";
	}

	@GetMapping("/homeVENDEDOR")
	public String homeVENDEDOR(Model model, @AuthenticationPrincipal User user, HttpSession session) {
		var title = "HomeProfile";
		if (session.getAttribute("actualProfile") == null)
			session.setAttribute("actualProfile", "VENDEDOR");
		if (session.getAttribute("menu") == null)
			session.setAttribute("menu", "fragments/menuVendedor.html");
		;
		model.addAttribute("title", title);
		model.addAttribute("profile", session.getAttribute("actualProfile"));
		model.addAttribute("menu", session.getAttribute("menu"));
		return "homeVENDEDOR";
	}

	@GetMapping("/homeUSER")
	public String homeUSER(Model model, @AuthenticationPrincipal User user, HttpSession session) {
		var title = "HomeProfile";
		if (session.getAttribute("actualProfile") == null)
			session.setAttribute("actualProfile", "USER");
		if (session.getAttribute("menu") == null)
			session.setAttribute("menu", "fragments/menuUser.html");
		model.addAttribute("title", title);
		model.addAttribute("profile", session.getAttribute("actualProfile"));
		model.addAttribute("menu", session.getAttribute("menu"));
		return "homeUSER";
	}

	@GetMapping("/abm_users")
	public String index(Model model, HttpSession session) {
		var title = "ABM-Users";
		model.addAttribute("title", title);
		model.addAttribute("users", userService.findAll());
		model.addAttribute("profile", session.getAttribute("actualProfile"));
		model.addAttribute("menu", session.getAttribute("menu"));
		return "abm_users";
	}

	@GetMapping("/addUser")
	public String addUser(Usr user, Model model, HttpSession session) {
		var title = "AddUser";
		model.addAttribute("title", title);
		model.addAttribute("profiles", profileService.findAll());
		model.addAttribute("profile", session.getAttribute("actualProfile"));
		model.addAttribute("menu", session.getAttribute("menu"));
		return ("addUser");
	}

	@PostMapping("/saveUser")
	public String saveUser(@Valid Usr user, Errors errors, Model model) {
		if (errors.hasErrors()) {
			if (userService.findByUsername(user.getUsername()) != null)
				model.addAttribute("existUsername", true);
			if (userService.findByEmail(user.getEmail()) != null)
				model.addAttribute("existEmail", true);
			model.addAttribute("profiles", profileService.findAll());
			return ("addUser");
		}
		var pass = user.getPassword();
		user.setPassword(passwordEncoder.encode(pass));
		if (user.getDate_account() == null) {
			LocalDate date = LocalDate.now();
			user.setDate_account(date);
		}
		userService.save(user);
		return "redirect:/users/abm_users";
	}

	@PostMapping("/saveNewUser")
	public String saveNewUser(@Valid Usr user, Errors errors, Model model) {
		if (errors.hasErrors()) {
			if (userService.findByUsername(user.getUsername()) != null)
				model.addAttribute("existUsername", true);
			if (userService.findByEmail(user.getEmail()) != null)
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
		if (user.getDate_account() == null) {
			LocalDate date = LocalDate.now();
			user.setDate_account(date);
		}
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
		model.addAttribute("menu", session.getAttribute("menu"));
		model.addAttribute("usr", user);
		return "addUser";
	}

	@GetMapping("/deleteUser")
	public String deleteUser(Usr user) {
		userService.deleteById(user);
		return "redirect:/users/abm_users";
	}

	@GetMapping("/findUser")
	public String findUser(Model model, HttpSession session) {
		var title = "FindUser";
		model.addAttribute("title", title);
		model.addAttribute("profile", session.getAttribute("actualProfile"));
		model.addAttribute("menu", session.getAttribute("menu"));
		return ("findUser");
	}

	@GetMapping("/formFindUserByEmail")
	public String formFindUserByEmail() {
		return ("formFindUserByEmail");
	}

	@GetMapping("/formFindUserByUsername")
	public String formFindUserByUsername() {
		return ("formFindUserByUsername");
	}

	@GetMapping("/findUserByEmail")
	public String findUserByEmail(@RequestParam(value = "email") String email, Model model) {
		model.addAttribute("user", userService.findByEmail(email));
		return "findUserResult";
	}

	@GetMapping("/findUserByUsername")
	public String findUserByUsername(@RequestParam(value = "username") String username, Model model) {
		model.addAttribute("user", userService.findByUsername(username));
		return "findUserResult";
	}
}
