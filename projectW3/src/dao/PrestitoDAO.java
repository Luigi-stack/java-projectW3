package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Prestito;
import model.elemento;


public class PrestitoDAO implements IprestitoDAO {

	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("projectW3");
	static EntityManager em = emf.createEntityManager();
	
	@Override
	public void salvaPrestito(Prestito u) {
		try {
			em.getTransaction().begin();
			em.persist(u);
			em.getTransaction().commit();
			System.out.println("Utente salvato nel DB!!");
		} catch (Exception ut) {
			em.getTransaction().rollback();
			System.out.println("Errore su salvataggio!!");
		} finally {
			em.close();
		}
	}
	
	
	@Override
	public List<elemento> ricercaElementiInPrestito(String numeroTesseraUtente) {
	    TypedQuery<elemento> query = em.createNamedQuery("prestito.findByNumeroTesseraUtente", elemento.class);
	    query.setParameter("numeroTessera", numeroTesseraUtente);
	    return query.getResultList();
	}

	@Override
	public List<elemento> ricercaPrestitiScadutiNonRestituiti() {
	    TypedQuery<elemento> query = em.createNamedQuery("prestito.findScadutiNonRestituiti", elemento.class);
	    return query.getResultList();
	}

	
}
