package com.cervelBuenTrato.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/users")
public class UserController {
	/*
	 * @Autowired private UserRepositoryService userService;
	 * 
	 * @GetMapping("/abm_users") public String index(Model model) { var title =
	 * "ABM-Users"; var users = userService.findAll(); model.addAttribute("title",
	 * title); model.addAttribute("users", users); return "abm_users"; }
	 * 
	 * @GetMapping("/addUser") public String addUser(Usr user, Model model) { var
	 * title = "AddUser"; model.addAttribute("title", title); return ("addUser"); }
	 * 
	 * @PostMapping("/saveUser") public String saveUser(@Valid Usr user, Errors
	 * errors) { if (errors.hasErrors()) return ("addUser"); userService.save(user);
	 * return "redirect:/users/abm_users"; }
	 * 
	 * @GetMapping("/editUser/{id_user}") public String editUser(Usr user, Model
	 * model) { var title = "EditUser"; model.addAttribute("title", title); user =
	 * userService.findById(user).get(); model.addAttribute("user", user); return
	 * "addUser"; }
	 * 
	 * @GetMapping("/deleteUser") public String deleteUser(Usr user) {
	 * userService.deleteById(user); return "redirect:/users/abm_users"; }
	 */
}
