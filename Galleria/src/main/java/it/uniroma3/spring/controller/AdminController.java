package it.uniroma3.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.uniroma3.spring.model.Amministratore;
import it.uniroma3.spring.model.Autorizzazione;
import it.uniroma3.spring.service.AmministratoreService;
import it.uniroma3.spring.service.AutoreService;
import it.uniroma3.spring.service.AutorizzazioneService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class AdminController {
	@Autowired
	private AutoreService autoreService;
	@Autowired
	private AmministratoreService amministratoreService;
	@Autowired 
	private AutorizzazioneService autorizzazioneService;
	
	@GetMapping("/admin")
	public String visualizzaElencoAutori(Model model) {
	    model.addAttribute("autori", autoreService.findAll());
	    return "homeAdmin";
	}
	
	 @GetMapping(value="/logout")
     public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){    
           new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "galleria";
     }
	 
	 @GetMapping("/admin/nuovoAmministratore")
	    public String showFormAmministratore(Amministratore amministratore) {
			return "formAmministratore";
	}
	 
	 @PostMapping("/admin/nuovoAmministratore")
	    public String checkAmministratoreInfo(@Valid @ModelAttribute Amministratore amministratore, 
	    									BindingResult bindingResult, Model model) {
	        if (bindingResult.hasErrors()) {
	            return "formAmministratore";
	        }
	        else {
	        	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
				String password = passwordEncoder.encode(amministratore.getPassword());
				amministratore.setPassword(password);
				amministratore.setEnabled(true);
	        	model.addAttribute(amministratore);
	            amministratoreService.add(amministratore);
	            Autorizzazione autorizzazione = new Autorizzazione();
	            autorizzazione.setAuthority("ROLE_ADMIN");
	            autorizzazione.setUsername(amministratore.getUsername());
	            autorizzazioneService.add(autorizzazione);
	            model.addAttribute("autori", autoreService.findAll());
	        return "homeAdmin";
	     }
	 }
	 @GetMapping("/admin/amministratore")
		public String visualizzaElencoAdmin(Model model) {
		    model.addAttribute("amministratori", amministratoreService.findAll());
		    return "gestioneAdmin";
		}
	 
	 @GetMapping("/admin/rimuoviAmministratore")
	    public String rimuoviAmministratore(@RequestParam("id") String id, Model model) {
		 	Amministratore amministratore = this.amministratoreService.findByUsername(id);
		    this.amministratoreService.remove(amministratore);
		    Autorizzazione autorizzazione = this.autorizzazioneService.findByUsername(id);
		    this.autorizzazioneService.remove(autorizzazione);
		    model.addAttribute("amministratori", amministratoreService.findAll());
		    return "gestioneAdmin";
		}
}
