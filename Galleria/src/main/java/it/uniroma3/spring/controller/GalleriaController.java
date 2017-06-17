package it.uniroma3.spring.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import it.uniroma3.spring.service.QuadroService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class GalleriaController {
	
	@Autowired
	private QuadroService quadroService;
	
	@GetMapping("/entra")
	public String entra(Model model) {
		model.addAttribute("quadri", quadroService.findAll());
		return "galleria";
	} 
}