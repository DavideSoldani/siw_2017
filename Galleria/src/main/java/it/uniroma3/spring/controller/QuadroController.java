package it.uniroma3.spring.controller;




import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import it.uniroma3.spring.model.Autore;
import it.uniroma3.spring.model.Quadro;
import it.uniroma3.spring.service.AutoreService;
import it.uniroma3.spring.service.QuadroService;



@Controller
public class QuadroController  {
	
    @Autowired
    private QuadroService quadroservice; 
    @Autowired
    private AutoreService autoreservice;

    @GetMapping("/admin/quadro")
    public String showFormQuadro(Quadro quadro) {
		return "formQuadro";
	}

    @PostMapping("/admin/quadro")
    public String checkQuadroInfo(@Valid @ModelAttribute Quadro quadro, 
    									BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "formQuadro";
        }
        else {
        	List<Autore> autori = (List<Autore>) autoreservice.findAll();
        	model.addAttribute(quadro);
        	model.addAttribute(autori);
            quadroservice.add(quadro); 
        
        return "riepilogoNuovoQuadro";
        }
    }
}
