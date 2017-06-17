package it.uniroma3.spring.repository;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.spring.model.Amministratore;

public interface AmministratoreRepository extends CrudRepository<Amministratore, Long> {
	
	Amministratore findByUsername(String Username);
}