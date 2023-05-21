package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import util.Periodicita;

@Entity
@Table(name = "riviste")
public class Rivista extends elemento {
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Periodicita periodicita;
	
	

	public Rivista() {
		super();
	}

	public Rivista(Periodicita periodicita) {
		super();
		this.periodicita = periodicita;
	}

	public Periodicita getPeriodicita() {
		return periodicita;
	}

	public void setPeriodicita(Periodicita periodicita) {
		this.periodicita = periodicita;
	}

	@Override
	public String toString() {
		return "Rivista [periodicita=" + periodicita + "]";
	}
	
	
	

}