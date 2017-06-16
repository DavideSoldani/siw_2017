package it.uniroma3.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.uniroma3.spring.service.AutoreService;

@Controller
public class AutoriController {
	@Autowired
	private AutoreService autoreService;
	
	@GetMapping("/mostraListaAutori")
	public String visualizzaElenco(Model model) {
	    model.addAttribute("autori", autoreService.findAll());
	    model.addAttribute("postMode","/mostraQuadriPerAutore");
	    model.addAttribute("selectText","Lista Quadri");
	    model.addAttribute("onClickSelect","");
	    model.addAttribute("vecchiaPagina","location.href='/'");
	    return "Autori";
	}
	
	@GetMapping("/selezionaAutore")
	public String scegliAutore(Model model) {
	    model.addAttribute("autori", autoreService.findAll());
	    model.addAttribute("postMode","/scelgiAutorer");
	    model.addAttribute("selectText","Seleziona");
	    model.addAttribute("onClickSelect","");
	    model.addAttribute("vecchiaPagina","location.href='/Autori'");
	    return "Autori";
	}
	
	@GetMapping("/modificaAutori")
	public String authorListManager(Model model) {
	    model.addAttribute("autori", autoreService.findAll());
	    model.addAttribute("postMode","/cancellaAutore");
	    model.addAttribute("selectText","Cancella");
	    model.addAttribute("onClickSelect","return confirm('Tutti i quadri collegati saranno cancellati continuare?')");
	    model.addAttribute("vecchiaPagina","location.href='Autori'");
	    return "Autori";
	}
	
	
	
	@PostMapping("/cancellaAutore")
	public String rimuoviAutore(@RequestParam("autoreId") long autoreId, Model model) {
	    autoreService.remove(autoreId);
	    return authorListManager(model);
	}
}
