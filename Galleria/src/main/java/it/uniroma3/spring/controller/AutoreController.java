package it.uniroma3.spring.controller;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.uniroma3.spring.model.Autore;
import it.uniroma3.spring.service.AutoreService;



@Controller
public class AutoreController  {
	
    @Autowired
    private AutoreService autoreservice; 
    
    
    @ModelAttribute("autore")
    public Autore autore() {
     return new Autore();
    }
    
    @GetMapping("/admin/autore")
    public String showFormAutore(Autore autore) {
		return "formAutore";
	}

    @PostMapping("/admin/autore")
    public String checkAutoreInfo(@Valid @ModelAttribute Autore autore, 
    									BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "formAutore";
        }
        else {
        	model.addAttribute(autore);
            autoreservice.add(autore); 
        
        return "riepilogoNuovoAutore";
        }
    }
    
    @GetMapping("/infoAutore")
    public String mostraAutore(@RequestParam("id") long id, Model model) {
	    model.addAttribute("autore", autoreservice.findbyId(id));
	    return "infoAutore";
	}
    
    @GetMapping("/listaAutori")
    public String listaAutori(Model model) {
	    model.addAttribute("autori", autoreservice.findAll());
	    return "listaAutori";
	}
    
    
    @GetMapping("/admin/rimuoviAutore")
    public String rimuoviAutore(@RequestParam("id") long id, Model model) {
	    autoreservice.remove(id);
	    model.addAttribute("autori", autoreservice.findAll());
	    return "homeAdmin";
	}
    
    @GetMapping("/admin/modificaAutore")
    public String modifica(@RequestParam("id") long id, Model model) {
	    model.addAttribute("id",id);
	    Autore autore = autoreservice.findbyId(id);
	    model.addAttribute("autore",autore);
	    model.addAttribute("autori", autoreservice.findAll());
	    return "homeAdmin";
	}
    
    @PostMapping("/admin/editAutore")
    public String edit(@Valid @ModelAttribute("autore") Autore autore,
							BindingResult bindingResult, Model model) {
    	if (bindingResult.hasErrors()) {
    		
    	    model.addAttribute("autori", autoreservice.findAll());
    	    return "homeAdmin";
    	}
    	autoreservice.add(autore); 
    	model.addAttribute("autori", autoreservice.findAll());
	    return "homeAdmin";
	}
    
    
}
