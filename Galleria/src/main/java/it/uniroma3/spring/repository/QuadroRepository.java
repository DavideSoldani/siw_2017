package it.uniroma3.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import it.uniroma3.spring.model.Quadro;


public interface QuadroRepository extends CrudRepository<Quadro, Long> {

    List<Quadro> findByTitolo(String titolo);

    List<Quadro> findByAnno(String anno);
    
    List<Quadro> findByTecnica(String tecnica);
    
    List<Quadro> findByAutore_Id(Long id); 
    
}