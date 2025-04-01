package no;

public class Account {
	
	// ATTRIBUTI
	private String nome;
	private String cognome;
	private String email;
	
	// COSTRUTTORE E METODI
	
	public Account(String nome, String cognome, String email){
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
	}
	
	
	// GETTER & 7R

	public String getNome() {
		return this.nome;
	}
	
	public String getCognome() {
		return this.cognome;
	}
	
	public String getEmail() {
		return this.email;
	}
}
