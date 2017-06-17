package it.uniroma3.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.spring.model.Autorizzazione;
import it.uniroma3.spring.repository.AutorizzazioneRepository;

@Service
public class AutorizzazioneService {

    @Autowired
    private AutorizzazioneRepository autorizzazioneRepository; 

    public Iterable<Autorizzazione> findAll() {
        return this.autorizzazioneRepository.findAll();
    }

    @Transactional
    public void add(final Autorizzazione autorizzazione) {
        this.autorizzazioneRepository.save(autorizzazione);
    }

	public void remove(Autorizzazione autorizzazione) {
		 this.autorizzazioneRepository.delete(autorizzazione);
		
	}
	
	public Autorizzazione findByUsername(String username){
		return this.autorizzazioneRepository.findByUsername(username);
	}

}