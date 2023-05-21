package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Utente;


public class UtenteDAO implements IUtenteDAO {

	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("projectW3");
	static EntityManager em = emf.createEntityManager();

	@Override
	public void salvaUtente(Utente u) {
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
}
