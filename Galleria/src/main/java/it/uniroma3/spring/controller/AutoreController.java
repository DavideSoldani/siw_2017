package it.uniroma3.spring.controller;

import java.text.Format;
import java.text.SimpleDateFormat;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import it.uniroma3.spring.model.Autore;
import it.uniroma3.spring.service.AutoreService;



@Controller
public class AutoreController  {
	
    @Autowired
    private AutoreService autoreservice; 

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
}
