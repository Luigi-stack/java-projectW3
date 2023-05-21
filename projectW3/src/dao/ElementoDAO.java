package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.elemento;

public class ElementoDAO implements IElementoDAO {

	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("projectW3");
	static EntityManager em = emf.createEntityManager();

	@Override
	public void salvaElemento(elemento e) {
		try {
			em.getTransaction().begin();
			em.persist(e);
			em.getTransaction().commit();
			System.out.println("Evento salvato nel DB!!");
		} catch (Exception ev) {
			em.getTransaction().rollback();
			System.out.println("Errore su salvataggio!!");
		} finally {
			em.close();
		}
	}

	@Override
	public void eliminaElemento(long i) {
		try {
			em.getTransaction().begin();
			elemento el = em.find(elemento.class, i);
			em.remove(el);
			em.getTransaction().commit();
			System.out.println("Elemento " + i + " eliminato!!");
		} catch (Exception ev) {
			em.getTransaction().rollback();
			System.out.println("Errore su salvataggio!!");
		} finally {
			em.close();
		}			
	}
	
	
		@Override
	    public elemento ricercaPerISBN(long codiceISBN) {
	        TypedQuery<elemento> query = em.createNamedQuery("elemento.findByISBN", elemento.class);
	        System.out.println("Elemento trovato tramite codice ISBN!!" + "Codice ISBN: " + codiceISBN);
	        query.setParameter("isbn", codiceISBN);
	        List<elemento> risultati = query.getResultList();
	        for (elemento elem : risultati) {
	            System.out.println("Titolo del libro: " + elem.getTitolo());
	        }
	        
	        return null;
	    }

	    
	    @Override
	    public List<elemento> ricercaPerTitolo(String titolo) {
	        TypedQuery<elemento> query = em.createNamedQuery("elemento.findByTitolo", elemento.class);
	        query.setParameter("titolo", "%" + titolo + "%");
	        List<elemento> risultati = query.getResultList();
	        
	        for (elemento elem : risultati) {
	            System.out.println("Titolo del libro: " + elem.getTitolo());
	        }
	        
	        return risultati;
	    }
	    
		@Override
		public List<elemento> ricercaPerAnnoPubblicazione(int annoPubblicazione) {
		    TypedQuery<elemento> query = em.createNamedQuery("elemento.findByAnnoPubblicazione", elemento.class);
		    query.setParameter("anno", annoPubblicazione);
		    List<elemento> titoli = query.getResultList();
		    
		    return titoli;
		}

}