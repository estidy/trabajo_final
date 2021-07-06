package com.cervelBuenTrato.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ControllerIndex {

	@GetMapping("/")
	public String index(Model model) {
		var title = "Home";
		model.addAttribute("title", title);
		return "index";
	}

}
