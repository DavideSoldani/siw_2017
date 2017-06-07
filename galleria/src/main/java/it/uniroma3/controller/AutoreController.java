package it.uniroma3.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.model.Autore;
import it.uniroma3.service.AutoreService;

@Controller
public class AutoreController {
	
	@Autowired
	private AutoreService autoreService;

	@RequestMapping(value="newAutore", method=RequestMethod.POST)
	public String newAutore(@Valid @ModelAttribute("autore") Autore autore, BindingResult result, Model model) {
		model.addAttribute("autore", autore);
		if(result.hasErrors()) {
			return "admin/newAutore";
		}
		else{
			autoreService.add(autore);
			return "admin/confermaDatiAutore";
		}
	}
	

	@RequestMapping(value="formAutore", method=RequestMethod.GET)
	public String formGet(Model model) {
		model.addAttribute("autore",new Autore());
		return "admin/newAutore";
	}
}
