package com.cervelBuenTrato.core.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cervelBuenTrato.core.model.Size;
import com.cervelBuenTrato.core.services.SizeService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("sizes")
public class SizeController {
	@Autowired
	private SizeService sizeService;

	@GetMapping("/abm_sizes")
	public String abmSizes(Model model, HttpSession session) {
		var title = "ABM-TypesBeer";
		model.addAttribute("title", title);
		model.addAttribute("sizes", sizeService.findAll());
		model.addAttribute("profile", session.getAttribute("actualProfile"));
		model.addAttribute("menu", session.getAttribute("menu"));
		return "abm_sizes";
	}

	@GetMapping("/addSize")
	public String addSize(Size size, Model model, HttpSession session) {
		var title = "AddTypeBeer";
		model.addAttribute("title", title);
		model.addAttribute("profile", session.getAttribute("actualProfile"));
		model.addAttribute("menu", session.getAttribute("menu"));
		return ("addSize");
	}

	@PostMapping("/saveSize")
	public String saveSize(@Valid Size size, HttpSession session) {
		sizeService.save(size);
		return "redirect:/sizes/abm_sizes";
	}

	@GetMapping("/editSize/{id_size}")
	public String editSize(Size size, Model model, HttpSession session) {
		var title = "EditTypeBeer";
		size = sizeService.findById(size).get();
		model.addAttribute("title", title);
		model.addAttribute("profile", session.getAttribute("actualProfile"));
		model.addAttribute("menu", session.getAttribute("menu"));
		model.addAttribute("size", size);

		return "addSize";
	}

	@GetMapping("/deleteSize")
	public String deleteSize(Size size) {
		sizeService.deleteById(size);
		return "redirect:/sizes/abm_sizes";
	}
}
