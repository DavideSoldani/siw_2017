package it.uniroma3.spring.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;



import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "users")
public class Amministratore {
	
	@NotEmpty(message="Campo Obbligatorio!")
	@Id
	private String username;
	@NotEmpty(message="Campo Obbligatorio!")
	private String password;
	private boolean enabled;

	public Amministratore(){}
	

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	
}