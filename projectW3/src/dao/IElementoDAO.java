package dao;
import java.util.List;

import model.elemento;

public interface IElementoDAO {

	public void salvaElemento(elemento e);
	public void eliminaElemento(long i);
	elemento ricercaPerISBN(long codiceISBN);
	List<elemento> ricercaPerTitolo(String titolo);
	List<elemento> ricercaPerAnnoPubblicazione(int annoPubblicazione);

}
