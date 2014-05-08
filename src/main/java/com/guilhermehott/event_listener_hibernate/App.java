package com.guilhermehott.event_listener_hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.guilhermehott.event_listener_hibernate.model.Person;

/**
 * Hello world!
 * 
 */
public class App {
	public static void main(String[] args) {
		Logger log = LoggerFactory.getLogger(App.class);
		log.info("Boostraping");
		// Use persistence.xml configuration
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("event-listener-hibernate");
		EntityManager em = emf.createEntityManager(); // Retrieve an application managed entity manager
		System.out.println();
		// Work with the EM
		Person person = new Person(1,"Guilherme","Hott",26);

		//salvar
		log.info("Save");
		em.persist(person);
		log.info(person.getFirstName());
		
		person.setFirstName("Cecilia");
		log.info("Update");
		em.persist(person);
		
		log.info("Find");
		Person p2 = em.find(Person.class, 1);
		log.info(p2.getFirstName());
		
		log.info("Remove");
		em.remove(p2);

		try {
			log.info("Find");
			Person p3 = em.find(Person.class, 1);
			log.info(p3.getFirstName());
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println();
		em.close();
		emf.close(); //close at application end
	}
}
