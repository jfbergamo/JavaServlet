// Bergamasco Jacopo, 5AIA, A.S. 2024-2025

package prova.pratica.webapp;

public class Prenotazione {
	
	public static String[] POSTI = {"Sala grande", "Sala piccola", "Terrazza", "Gazebo"};
	
	private String nome;
	private int posto;
	private int clienti;
	private int tel;
	
	public Prenotazione(String nome, int posto, int clienti, int tel) {
		this.nome = nome;
		this.posto = posto;
		this.clienti = clienti;
		this.tel = tel;
	}
	
	public static String getNomePosto(int posto) {
		return POSTI[posto];
	}
	
	public String getNomePosto() {
		return POSTI[posto];
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public int getPosto() {
		return this.posto;
	}
	
	
	public int getClienti() {
		return this.clienti;
	}
	
	public int getTel() {
		return this.tel;
	}
}
