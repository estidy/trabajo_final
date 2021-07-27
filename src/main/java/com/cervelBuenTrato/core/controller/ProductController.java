package com.cervelBuenTrato.core.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("products")

public class ProductController {

	@GetMapping("/selectProd")
	public String selectProd(Model model, HttpSession session) {
		var title = "SelectProd";
		model.addAttribute("title", title);
		model.addAttribute("profile", session.getAttribute("actualProfile"));
		model.addAttribute("menu", session.getAttribute("menu"));
		return ("selectProd");
	}

}
