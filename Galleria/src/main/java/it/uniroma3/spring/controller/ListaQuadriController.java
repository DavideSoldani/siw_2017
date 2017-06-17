package it.uniroma3.spring.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;




import it.uniroma3.spring.service.QuadroService;


@Controller
public class ListaQuadriController {
	@Autowired
	private QuadroService quadroService;
	
	
	@GetMapping("/admin/quadriAutore")
	public String visualizzaElencoQuadri(@RequestParam("id") Long id, Model model) {
		model.addAttribute("quadri", quadroService.findByAutore_Id(id));
	    return "listaQuadri";
	}
    

	
	
	 
}
	 
	 

