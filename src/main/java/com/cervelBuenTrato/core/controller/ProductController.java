package com.cervelBuenTrato.core.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cervelBuenTrato.core.model.Product;
import com.cervelBuenTrato.core.services.ProductService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("/abm_products")
	public String index(Model model) {
		var title = "ABM-Product";
		model.addAttribute("title", title);
		model.addAttribute("products", productService.findAll());
		return "abm_products";
	}

	@GetMapping("/addProd")
	public String addUser(Product prod, Model model) {
		var title = "AddProd";
		model.addAttribute("title", title);
		return ("addProd");
	}

	@PostMapping("/saveProd")
	public String saveUser(@Valid Product prod, Errors errors) {
		if (errors.hasErrors())
			return ("addProd");
		productService.save(prod);
		return "redirect:/products/abm_products";
	}

	@GetMapping("/editProd/{id_prod}")
	public String editUser(Product prod, Model model) {
		var title = "EditUser";
		prod = productService.findById(prod).get();
		model.addAttribute("title", title);
		model.addAttribute("prod", prod);

		return "addProd";
	}

	@GetMapping("/deleteProd")
	public String deleteUser(Product prod) {
		productService.deleteById(prod);
		return "redirect:/products/abm_products";
	}
}
