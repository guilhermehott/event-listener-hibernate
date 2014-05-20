package com.guilhermehott.elb;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.internal.SessionFactoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.guilhermehott.elb.model.Person;

/**
 * 
 * @author guilherme.hott
 * 
 */
public class App {
	public static void main(String[] args) {
		Logger log = LoggerFactory.getLogger(App.class);
		log.info("Boostraping");

//		runHibernateConfiguration(log);
		runHibernateProperties(log);
	}

	/**
	 * http://learningviacode.blogspot.com.br/2012/07/listeners-in-hibernate.html
	 * http://www.sitenol.com/create-sessionfactory-object-using-hibernate-cfg-xml-mysql
	 * http://docs.jboss.org/hibernate/stable/shards/reference/en/html/shards-configuration.html
	 * http://docs.jboss.org/hibernate/stable/annotations/reference/en/html/ch01.html
	 * 
	 * @param log
	 */
	public static void runHibernateConfiguration(Logger log) {
		// Use hibernate.cfg.xml configuration
		Configuration cfg = new Configuration();
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = cfg.configure().buildSessionFactory();
		Session em = sessionFactory.openSession();
		final EventListenerRegistry registry = ((SessionFactoryImpl) sessionFactory).getServiceRegistry().getService(EventListenerRegistry.class);
		registry.getEventListenerGroup(EventType.LOAD).appendListener((LoadEventListener) new LoadEventListener());

		System.out.println();
		Person person = new Person(1, "Guilherme", "Hott", 26);

		// salvar
		log.info("Save");
		em.persist(person);
		log.info(person.getFirstName());

		person.setFirstName("Cecilia");
		log.info("Update");
		em.persist(person);

		log.info("Find");
		Person p2 = (Person) em.get(Person.class, 1);
		log.info(p2.getFirstName());

//		log.info("Remove");
//		em.delete(p2);
//
//		try {
//			log.info("Find");
//			Person p3 = (Person) em.get(Person.class, 1);
//			log.info(p3.getFirstName());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

		System.out.println();
		em.close();
		sessionFactory.close(); // close at application end
	}

	public static void runHibernateProperties(Logger log) {
		// Use persistence.xml configuration
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("event-listener-hibernate");
		EntityManager em = emf.createEntityManager(); // Retrieve an application managed entity manager

		System.out.println();
		// Work with the EM
		Person person = new Person(null, "Guilherme", "Hott", 26);

		// salvar
		log.info("Save");
		em.persist(person);
		log.info(person.getFirstName());
		em.refresh(person);

//		person.setFirstName("Cecilia");
//		log.info("Update");
//		em.persist(person);
//
//		log.info("Find");
//		Person p2 = em.find(Person.class, 1);
//		log.info(p2.getFirstName());

//		log.info("Remove");
//		em.remove(p2);
//
//		try {
//			log.info("Find");
//			Person p3 = em.find(Person.class, 1);
//			log.info(p3.getFirstName());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

		System.out.println();
		em.close();
		emf.close(); // close at application end
	}
}
