package com.cervelBuenTrato.core.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cervelBuenTrato.core.services.ProductService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("products")

public class ProductController {
	@Autowired
	ProductService productService;

	@GetMapping("/selectProd")
	public String selectProd(Model model, HttpSession session) {
		var title = "SelectProd";
		model.addAttribute("title", title);
		model.addAttribute("profile", session.getAttribute("actualProfile"));
		model.addAttribute("menu", session.getAttribute("menu"));
		return ("selectProd");
	}

	@GetMapping("/nextProductsToExpire")
	public String nextProductsToExpire(Model model, HttpSession session) {
		var title = "nextProductsToExpire";
		var headerTitle = "LISTADO DE PRODUCTOS PROXIMOS A VENCER";
		model.addAttribute("title", title);
		model.addAttribute("headerTitle", headerTitle);
		model.addAttribute("products", productService.nextProductsToExpire());
		model.addAttribute("profile", session.getAttribute("actualProfile"));
		model.addAttribute("menu", session.getAttribute("menu"));
		return ("abm_products");
	}

	@GetMapping("/productsLessThanStockMin")
	public String productsLessThanStockMin(Model model, HttpSession session) {
		var title = "productsLessThanStockMin";
		var headerTitle = "LISTADO DE PRODUCTOS CON BAJO STOCK";
		model.addAttribute("title", title);
		model.addAttribute("headerTitle", headerTitle);
		model.addAttribute("products", productService.productsLessThanStockMin());
		model.addAttribute("profile", session.getAttribute("actualProfile"));
		model.addAttribute("menu", session.getAttribute("menu"));
		productService.nextProductsToExpire().forEach(System.out::println);
		return ("abm_products");
	}
}
