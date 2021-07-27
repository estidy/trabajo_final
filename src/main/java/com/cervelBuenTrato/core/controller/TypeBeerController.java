package com.cervelBuenTrato.core.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cervelBuenTrato.core.model.TypeBeer;
import com.cervelBuenTrato.core.services.TypeBeerService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("typeBeer")
public class TypeBeerController {

	@Autowired
	private TypeBeerService typeBeerService;

	@GetMapping("/abm_typesBeer")
	public String abmTypesBeer(Model model, HttpSession session) {
		var title = "ABM-TypesBeer";
		model.addAttribute("title", title);
		model.addAttribute("types", typeBeerService.findAll());
		model.addAttribute("profile", session.getAttribute("actualProfile"));
		model.addAttribute("menu", session.getAttribute("menu"));
		return "abm_typesBeer";
	}

	@GetMapping("/addTypeBeer")
	public String addTypeBeer(TypeBeer typeBeer, Model model, HttpSession session) {
		var title = "AddTypeBeer";
		model.addAttribute("title", title);
		model.addAttribute("profile", session.getAttribute("actualProfile"));
		model.addAttribute("menu", session.getAttribute("menu"));
		return ("addTypeBeer");
	}

	@PostMapping("/saveTypeBeer")
	public String saveTypeBeer(@Valid TypeBeer typeBeer, HttpSession session) {
		typeBeerService.save(typeBeer);
		return "redirect:/typeBeer/abm_typesBeer";
	}

	@GetMapping("/editTypeBeer/{id_type_beer}")
	public String editTypeBeer(TypeBeer typeBeer, Model model, HttpSession session) {
		var title = "EditTypeBeer";
		typeBeer = typeBeerService.findById(typeBeer).get();
		model.addAttribute("title", title);
		model.addAttribute("typeBeer", typeBeer);
		model.addAttribute("profile", session.getAttribute("actualProfile"));
		model.addAttribute("menu", session.getAttribute("menu"));
		return "addTypeBeer";
	}

	@GetMapping("/deleteTypeBeer")
	public String deleteTypeBeer(TypeBeer typeBeer) {
		typeBeerService.deleteById(typeBeer);
		return "redirect:/typeBeer/abm_typesBeer";
	}
}
