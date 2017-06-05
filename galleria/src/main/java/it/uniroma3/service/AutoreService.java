package it.uniroma3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.model.Autore;
import it.uniroma3.repository.AutoreRepository;

@Service
public class AutoreService {
	
	@Autowired
	private AutoreRepository autoreRepository;
	
	public Iterable<Autore> findAll(){
		return this.autoreRepository.findAll();
	}
	
	@Transactional
	public void add(final Autore autore){
		this.autoreRepository.save(autore);
	}

}
