package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "utenti")
public class Utente {

	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String cognome;
	
	@Column(name= "data_nascita", nullable = false)
	private LocalDate dataNascita;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "numero_tessera", nullable = false)
	private long numeroTessera;
	
	 @OneToMany(mappedBy = "utente", cascade = CascadeType.ALL)
	 private List<Prestito> prestiti;
	
	

	public Utente() {
		super();
	}

	public Utente(String nome, String cognome, LocalDate dataNascita) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
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

	public LocalDate getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(LocalDate dataNascita) {
		this.dataNascita = dataNascita;
	}

	public long getNumeroTessera() {
		return numeroTessera;
	}

	public void setNumeroTessera(long numeroTessera) {
		this.numeroTessera = numeroTessera;
	}

	@Override
	public String toString() {
		return "Utente [nome=" + nome + ", cognome=" + cognome + ", dataNascita=" + dataNascita + ", numeroTessera="
				+ numeroTessera + "]";
	}
	
}
