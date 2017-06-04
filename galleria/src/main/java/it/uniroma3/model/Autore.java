package it.uniroma3.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;


import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Autore {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotEmpty(message="Campo Obbligatorio!")
	private String nome;
	@NotEmpty(message="Campo obbligatorio!")
	private String cognome;
	@NotEmpty(message="Campo Obbligatorio!")
	private String nazionalita;
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@NotNull(message="Campo Obbligatorio!") @Past(message="Hai inserito una data futura!")
	private Date dataDiNascita;
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@NotNull(message="Campo Obbligatorio!") @Past(message="Hai inserito una data futura!")
	private Date dataDiMorte;
	private List<Opera> opere;


	public Autore() {}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCognome() {
		return cognome;
	}


	public void setCognome(String cognome) {
		this.cognome = cognome;
	}


	public String getNazionalita() {
		return nazionalita;
	}


	public void setNazionalita(String nazionalita) {
		this.nazionalita = nazionalita;
	}


	public Date getDataDiNascita() {
		return dataDiNascita;
	}


	public void setDataDiNascita(Date dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}


	public Date getDataDiMorte() {
		return dataDiMorte;
	}


	public void setDataDiMorte(Date dataDiMorte) {
		this.dataDiMorte = dataDiMorte;
	}


	public List<Opera> getOpere() {
		return opere;
	}


	public void setOpere(List<Opera> opere) {
		this.opere = opere;
	}

}
