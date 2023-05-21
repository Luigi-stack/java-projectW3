package model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQuery;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@NamedQuery(name = "elemento.findByISBN", query = "SELECT e FROM elemento e WHERE e.codiceISBN = :isbn")
@NamedQuery(name = "elemento.findByAnnoPubblicazione", query = "SELECT e FROM elemento e WHERE e.annoPubblicazione = :anno")
@NamedQuery(name = "elemento.findByTitolo", query = "SELECT e FROM elemento e WHERE e.titolo LIKE :titolo")
@NamedQuery(name = "prestito.findByNumeroTesseraUtente", query = "SELECT p.elemento FROM Prestito p WHERE p.utente.numeroTessera = :numeroTessera AND p.dataRestituzioneEffettiva IS NULL")
@NamedQuery(name = "prestito.findScadutiNonRestituiti", query = "SELECT p.elemento FROM Prestito p WHERE p.dataRestituzionePrevista < CURRENT_DATE AND p.dataRestituzioneEffettiva IS NULL")
public abstract class elemento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codice_isbn")
	private long codiceISBN;
	
	@Column(nullable = false)
	private String titolo;
	
	@Column(name = "anno_pubblicazione", nullable = false)
	private int annoPubblicazione;
	
	@Column(name = "numero_pagine", nullable = false)
	private Integer numeroPagine;

	public elemento() {
		super();
	}

	public elemento(String titolo, int annoPubblicazione, Integer numeroPagine) {
		super();
		this.titolo = titolo;
		this.annoPubblicazione = annoPubblicazione;
		this.numeroPagine = numeroPagine;
	}

	public long getCodiceISBN() {
		return codiceISBN;
	}

	public void setCodiceISBN(long codiceISBN) {
		this.codiceISBN = codiceISBN;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public int getAnnoPubblicazione() {
		return annoPubblicazione;
	}

	public void setAnnoPubblicazione(int annoPubblicazione) {
		this.annoPubblicazione = annoPubblicazione;
	}

	public Integer getNumeroPagine() {
		return numeroPagine;
	}

	public void setNumeroPagine(Integer numeroPagine) {
		this.numeroPagine = numeroPagine;
	}

	@Override
	public String toString() {
		return "elemento [codiceISBN=" + codiceISBN + ", titolo=" + titolo + ", annoPubblicazione=" + annoPubblicazione
				+ ", numeroPagine=" + numeroPagine + "]";
	}
	
	
}
