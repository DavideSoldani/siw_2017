package it.uniroma3.spring.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Quadro {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotEmpty(message="Campo Obbligatorio!")
	private String titolo;
	@NotEmpty(message="Campo Obbligatorio!")  @Pattern(regexp = "[0-9]+",message="Solo numeri ammessi!") @Size(min=4,max=4,message="Devi inserire al massimo 4 cifre!")
	private String anno;
	@NotEmpty(message="Campo Obbligatorio!")
	private String tecnica;
	@NotEmpty(message="Campo Obbligatorio!")
	private String dimensioni;
	@ManyToOne
	@NotNull
	private Autore autore;
	
	public Autore getAutore() {
		return autore;
	}

	public void setAutore(Autore autore) {
		this.autore = autore;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getAnno() {
		return anno;
	}

	public void setAnno(String anno) {
		this.anno = anno;
	}

	public String getTecnica() {
		return tecnica;
	}

	public void setTecnica(String tecnica) {
		this.tecnica = tecnica;
	}

	public String getDimensioni() {
		return dimensioni;
	}

	public void setDimensioni(String dimensioni) {
		this.dimensioni = dimensioni;
	}
}
