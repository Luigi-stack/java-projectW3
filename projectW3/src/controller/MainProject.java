package controller;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import model.*;
import util.Periodicita;
import dao.ElementoDAO;
import dao.UtenteDAO;
import dao.IElementoDAO;
import dao.IUtenteDAO;
import dao.IprestitoDAO;
import dao.PrestitoDAO;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainProject {

	static EntityManagerFactory emf=Persistence.createEntityManagerFactory("projectW3");
    static EntityManager em=emf.createEntityManager();
    
//    static IElementoDAO elementoDAO = new ElementoDAO();
//    static IUtenteDAO ut = new UtenteDAO();



    public static void main(String[] args) {

        try {
        	
        	IElementoDAO el = new ElementoDAO();
        	IUtenteDAO ut = new UtenteDAO();
        	IprestitoDAO prestito = new PrestitoDAO();
        	
        	   Libro c1 = new Libro();
        	   c1.setAnnoPubblicazione(2022);
        	   c1.setAutore("Pinco Pallino");
        	   c1.setGenere("Comico");
        	   c1.setNumeroPagine(300);
        	   c1.setTitolo("Ciao mondo");
        	   
        	   Libro c2 = new Libro();
        	   c2.setAnnoPubblicazione(2020);
        	   c2.setAutore("Luca");
        	   c2.setGenere("Avventura");
        	   c2.setNumeroPagine(150);
        	   c2.setTitolo("Lo schiaccianoci");
        	   
        	   Rivista r1 = new Rivista();
        	   r1.setAnnoPubblicazione(2022);
        	   r1.setNumeroPagine(100);
        	   r1.setPeriodicita(Periodicita.MENSILE);
        	   r1.setTitolo("supercalifragilistichespiralitoso");
        	   
        	   
        	   int annoRicerca = 2022;
               List<elemento> titoliPubblicati = el.ricercaPerAnnoPubblicazione(annoRicerca);
               
               System.out.println("I titoli pubblicati nell'anno " + annoRicerca + ":");
               for (elemento libro : titoliPubblicati) {
                   System.out.println(libro.getTitolo());
               }
        	   
        	   Utente u1 = new Utente();
        	   u1.setCognome("Iossa");
        	   u1.setNome("Luigi");
        	   u1.setDataNascita(LocalDate.of(1993, 6, 27));
        	   
//        	   ut.salvaUtente(u1);
        	   
        	   Prestito p1 = new Prestito();
        	   p1.setUtente(u1);
        	   p1.setElemento(r1);
        	   p1.setInizioPrestito(LocalDate.of(2023, 4, 5));
        	   p1.setRestituzionePrevista(LocalDate.of(2023, 4, 29));
        	   p1.setDataRestituzione(LocalDate.of(2023, 5, 10));
        	   
        	   prestito.ricercaElementiInPrestito(null);                           
  
     	    
        	

        }catch(Exception e) {
            System.out.println("ERRORE! "+e);
        }finally {
            emf.close();
            em.close();
        }

}
    

}
