package model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table (name="prestiti")
public class Prestito {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	private Utente utente;
	
	@ManyToOne
	private elemento elemento;
	
	@Column(name="inizio_prestito")
	private LocalDate inizioPrestito;
	
	@Column(name="restituzione_prevista")
	private LocalDate restituzionePrevista;
	
	@Column(name="data_restituzione")
	private LocalDate dataRestituzione;

	public Prestito() {
		super();
	}

	public Prestito(Utente utente, model.elemento elemento, LocalDate inizioPrestito, LocalDate restituzionePrevista,
			LocalDate dataRestituzione) {
		super();
		this.utente = utente;
		this.elemento = elemento;
		this.inizioPrestito = inizioPrestito;
		this.restituzionePrevista = restituzionePrevista;
		this.dataRestituzione = dataRestituzione;
	}
	
	@PrePersist
	private void restituzionePrevista() {
		if(inizioPrestito != null) {
			restituzionePrevista = inizioPrestito.plusDays(30);
		}
	}
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public elemento getElemento() {
		return elemento;
	}

	public void setElemento(elemento elemento) {
		this.elemento = elemento;
	}

	public LocalDate getInizioPrestito() {
		return inizioPrestito;
	}

	public void setInizioPrestito(LocalDate inizioPrestito) {
		this.inizioPrestito = inizioPrestito;
	}

	public LocalDate getRestituzionePrevista() {
		return restituzionePrevista;
	}

	public void setRestituzionePrevista(LocalDate restituzionePrevista) {
		this.restituzionePrevista = restituzionePrevista;
	}

	public LocalDate getDataRestituzione() {
		return dataRestituzione;
	}

	public void setDataRestituzione(LocalDate dataRestituzione) {
		this.dataRestituzione = dataRestituzione;
	}

	@Override
	public String toString() {
		return "Prestito [id=" + id + ", utente=" + utente + ", elemento=" + elemento + ", inizioPrestito="
				+ inizioPrestito + ", restituzionePrevista=" + restituzionePrevista + ", dataRestituzione="
				+ dataRestituzione + "]";
	}
	
	
	
	
	
}
