package it.uniroma3.spring.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.uniroma3.spring.model.Quadro;
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

	@PostMapping("/galleria/filtra")
	public String filtra(Model model, @RequestParam("filterType") String filterType, 
			@RequestParam("filtro") String filtro){
		List<Quadro> quadri;
		if (filtro.equals(""))
			quadri = (List<Quadro>) quadroService.findAll();
		else{
			if (filterType.equals("titolo"))
				quadri = (List<Quadro>) quadroService.findByTitolo(filtro);
			else if (filterType.equals("anno"))
				quadri = (List<Quadro>) quadroService.findByAnno(filtro);
			else if (filterType.equals("tecnica"))
				quadri = (List<Quadro>) quadroService.findByTecnica(filtro);
			else
				quadri = (List<Quadro>) quadroService.findAll();
		}
		
		if (quadri.size() == 0)
			model.addAttribute("listaVuota",true);
		model.addAttribute("quadri",quadri);
		return "galleria";
	}
}