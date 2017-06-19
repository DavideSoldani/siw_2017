package it.uniroma3.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.spring.model.Quadro;
import it.uniroma3.spring.repository.QuadroRepository;

@Service
public class QuadroService {

    @Autowired
    private QuadroRepository quadroRepository; 

    public Iterable<Quadro> findAll() {
        return this.quadroRepository.findAll();
    }
    
    public Iterable<Quadro> findByAutore_Id(Long id) {
        return this.quadroRepository.findByAutore_Id(id);
    }
    
    public Iterable<Quadro> findByTitolo(String titolo) {
        return this.quadroRepository.findByTitolo(titolo);
    }
    
    public Iterable<Quadro> findByTecnica(String tecnica) {
        return this.quadroRepository.findByTecnica(tecnica);
    }
    
    public Iterable<Quadro> findByAnno(String anno) {
        return this.quadroRepository.findByAnno(anno);
    }
    
    @Transactional
    public void add(final Quadro quadro) {
        this.quadroRepository.save(quadro);
    }

	public Quadro findbyId(Long id) {
		return this.quadroRepository.findOne(id);
	}
     
	public void remove(long quadroId) {
		 this.quadroRepository.delete(quadroId);
		
	}

}