package it.uniroma3.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.spring.model.Amministratore;
import it.uniroma3.spring.repository.AmministratoreRepository;


@Service
public class AmministratoreService {

    @Autowired
    private AmministratoreRepository amministratoreRepository;

    public Iterable<Amministratore> findAll() {
        return this.amministratoreRepository.findAll();
    }

    @Transactional
    public void add(final Amministratore amministratore) {
        this.amministratoreRepository.save(amministratore);
    }

	public void remove(Amministratore amministratore) {
		 this.amministratoreRepository.delete(amministratore);
		
	}
	
	public Amministratore findByUsername(String username){
		return this.amministratoreRepository.findByUsername(username);
	}

}