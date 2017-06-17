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
import org.springframework.web.bind.annotation.RequestParam;

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
    
    @ModelAttribute("quadro")
    public Quadro quadro() {
     return new Quadro();
    }

    @GetMapping("/admin/quadro")
    public String showFormQuadro(Quadro quadro, Model model) {
    	List<Autore> autori = (List<Autore>) autoreservice.findAll();
    	model.addAttribute("autori",autori);
		return "formQuadro";
	}

    @PostMapping("/admin/quadro")
    public String checkQuadroInfo(@Valid @ModelAttribute Quadro quadro, 
    									BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
        	List<Autore> autori = (List<Autore>) autoreservice.findAll();
        	model.addAttribute("autori",autori);
            return "formQuadro";
        }
        else {
        	model.addAttribute(quadro);
            quadroservice.add(quadro); 
        
        return "riepilogoNuovoQuadro";
        }
    }
    
    @GetMapping("/admin/rimuoviQuadro")
    public String rimuoviQuadro(@RequestParam("autoreId") String autoreId, 
    							@RequestParam("quadroId") long quadroId, Model model) {
    	long autorId = Long.parseLong(autoreId);
    	Autore autore = autoreservice.findbyId(autorId);
	    quadroservice.remove(quadroId);
	    model.addAttribute("quadri", quadroservice.findByAutore_Id(autorId));
	    model.addAttribute("autore",autore);
	    return "listaQuadri";
	}
    
    @GetMapping("/admin/modificaQuadro")
    public String modifica(@RequestParam("autoreId") String autoreId, 
							@RequestParam("quadroId") long quadroId, Model model){
	    Quadro quadro = quadroservice.findbyId(quadroId);
	    long autorId = Long.parseLong(autoreId);
    	Autore autore = autoreservice.findbyId(autorId);
    	model.addAttribute("quadroId",quadroId);
	    model.addAttribute("quadro",quadro);
	    model.addAttribute("autore",autore);
	    model.addAttribute("quadri", quadroservice.findAll());
	    return "listaQuadri";
	}
    
    @PostMapping("/admin/editQuadro")
    public String edit(@Valid @ModelAttribute("quadro") Quadro quadro,@RequestParam("autoreId") String autoreId, 
							BindingResult bindingResult, Model model) {
    	if (bindingResult.hasErrors()) {
    		
    	    model.addAttribute("quadri", quadroservice.findAll());
    	    return "homeAdmin";
    	}
    	long autorId = Long.parseLong(autoreId);
    	Autore autore = autoreservice.findbyId(autorId);
    	model.addAttribute("autore",autore);
    	quadroservice.add(quadro); 
    	model.addAttribute("quadri", quadroservice.findAll());
	    return "listaQuadri";
	}
}

