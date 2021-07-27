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

import com.cervelBuenTrato.core.model.Beer;
import com.cervelBuenTrato.core.services.ProductService;
import com.cervelBuenTrato.core.services.TypeBeerService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("beers")
public class BeerController {

	@Autowired
	private ProductService productService;

	@Autowired
	private TypeBeerService typeBeerService;

	@GetMapping("/abm_products_beers")
	public String abm_products_beer(Model model, HttpSession session) {
		var title = "ABM-Product_beer";
		model.addAttribute("title", title);
		model.addAttribute("products", productService.findAll());
		model.addAttribute("profile", session.getAttribute("actualProfile"));
		model.addAttribute("menu", session.getAttribute("menu"));
		return "abm_products_beers";
	}

	@GetMapping("/addProdTypeBeer")
	public String addProdTypeBeer(Beer beer, Model model, HttpSession session) {
		var title = "AddBeer";
		model.addAttribute("title", title);
		model.addAttribute("types", typeBeerService.findAll());
		model.addAttribute("profile", session.getAttribute("actualProfile"));
		model.addAttribute("menu", session.getAttribute("menu"));
		return ("addProdTypeBeer");
	}

	@PostMapping("/saveProdBeer")
	public String saveProdBeer(@Valid Beer beer) {
		var date = beer.getExpiration().toString();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localDate = LocalDate.parse(date, formatter);
		beer.setExpiration(localDate);
		productService.save(beer);
		return "redirect:/beers/abm_products_beers";
	}

	@GetMapping("/editProd/{id_product}")
	public String editProdBeer(Beer beer, Model model, HttpSession session) {
		var title = "EditUser";
		beer = (Beer) productService.findById(beer).get();
		model.addAttribute("types", typeBeerService.findAll());
		model.addAttribute("title", title);
		model.addAttribute("beer", beer);
		model.addAttribute("profile", session.getAttribute("actualProfile"));
		model.addAttribute("menu", session.getAttribute("menu"));
		return "addProdTypeBeer";
	}

	@GetMapping("/deleteProdBeer")
	public String deleteProdBeer(Beer beer) {
		productService.deleteById(beer);
		return "redirect:/beer/abm_products_beers";
	}

}
