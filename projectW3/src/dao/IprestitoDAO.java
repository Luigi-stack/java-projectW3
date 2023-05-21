package dao;

import java.util.List;

import model.Prestito;
import model.elemento;

public interface IprestitoDAO {

	public void salvaPrestito(Prestito u);

	List<elemento> ricercaElementiInPrestito(String numeroTesseraUtente);

	List<elemento> ricercaPrestitiScadutiNonRestituiti();

	
}
