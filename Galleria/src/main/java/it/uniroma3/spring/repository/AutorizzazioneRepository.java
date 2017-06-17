package it.uniroma3.spring.repository;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.spring.model.Autorizzazione;


public interface AutorizzazioneRepository extends CrudRepository<Autorizzazione, Long> {
	     
	Autorizzazione findByUsername(String username);
}