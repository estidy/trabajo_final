package com.cervelBuenTrato.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/")
public class IndexController {

	@GetMapping
	public String index(Model model) {
		var title = "Home";
		var text = "Ingresar";
		var link = "/login";
		model.addAttribute("title", title);
		model.addAttribute("text", text);
		model.addAttribute("link", link);
		return "index";
	}

}
