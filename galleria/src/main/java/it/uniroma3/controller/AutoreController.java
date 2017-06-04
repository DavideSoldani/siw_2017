package it.uniroma3.controller;

import javax.validation.Valid;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.model.Autore;

@Controller
public class AutoreController {


	@RequestMapping(value="/newAutore", method=RequestMethod.POST)
	public String newAutore(@Valid @ModelAttribute("autore") Autore autore, BindingResult result, Model model) {
		model.addAttribute("autore", autore);
		if(result.hasErrors()) {
			return "newAutore";
		}
		else
		return "confermaDatiAutore";
	}
	
	@RequestMapping(value="/admin/formAutore", method=RequestMethod.POST)
	public String formPost(Model model) {
		model.addAttribute("autore",new Autore());
		return "newAutore";
	}

	@RequestMapping(value="/admin/formAutore", method=RequestMethod.GET)
	public String formGet(Model model) {
		model.addAttribute("autore",new Autore());
		return "newAutore";
	}
}
