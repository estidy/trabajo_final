package com.cervelBuenTrato.core.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cervelBuenTrato.core.model.Snack;
import com.cervelBuenTrato.core.services.SizeService;
import com.cervelBuenTrato.core.services.SnackService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("snacks")

public class SnackController {

	@Autowired
	private SnackService snackService;

	@Autowired
	private SizeService sizeService;

	@GetMapping("/abm_products_snacks")
	public String abm_products_snack(Model model, HttpSession session) {
		var title = "ABM-Product_snack";
		model.addAttribute("title", title);
		model.addAttribute("products", snackService.findAll());
		model.addAttribute("profile", session.getAttribute("actualProfile"));
		model.addAttribute("menu", session.getAttribute("menu"));
		return "abm_products_snacks";
	}

	@GetMapping("/addProdTypeSnack")
	public String addProdTypeSnack(Snack snack, Model model, HttpSession session) {
		var title = "AddSnack";
		model.addAttribute("title", title);
		model.addAttribute("profile", session.getAttribute("actualProfile"));
		model.addAttribute("menu", session.getAttribute("menu"));
		model.addAttribute("sizes", sizeService.findAll());
		return ("addProdTypeSnack");
	}

	@PostMapping("/saveProdSnack")
	public String saveProdSnack(@Valid Snack snack) {
		var date = snack.getExpiration().toString();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localDate = LocalDate.parse(date, formatter);
		snack.setExpiration(localDate);
		snackService.save(snack);
		return "redirect:/snacks/abm_products_snacks";
	}

	@GetMapping("/editProdSnack/{id_product}")
	public String editProdSnack(Snack snack, Model model, HttpSession session) {
		var title = "EditProdSnack";
		snack = snackService.findById(snack).get();
		model.addAttribute("sizes", sizeService.findAll());
		model.addAttribute("profile", session.getAttribute("actualProfile"));
		model.addAttribute("menu", session.getAttribute("menu"));
		model.addAttribute("title", title);
		model.addAttribute("snack", snack);
		return "addProdTypeSnack";
	}

	@GetMapping("/deleteProdSnack")
	public String deleteProdSnack(Snack snack) {
		snackService.deleteById(snack);
		return "redirect:/snacks/abm_products_snacks";
	}

}
