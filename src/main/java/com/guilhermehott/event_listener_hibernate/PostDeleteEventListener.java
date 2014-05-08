package com.guilhermehott.event_listener_hibernate;

import javax.persistence.Table;

import org.hibernate.HibernateException;
import org.hibernate.event.spi.PostDeleteEvent;
import org.slf4j.Logger;

public class PostDeleteEventListener extends EJB3PostDeleteEventListener {
	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(PostDeleteEventListener.class);

	@SuppressWarnings("unchecked")
	@Override
	public void onPostDelete(PostDeleteEvent event) throws HibernateException {
		if (event.getEntity() instanceof Entidade) {
//			logger.info("onPostDelete: entity : " + event.getEntity().getClass());
			logger.info("onPostDelete: table: " 
					+ ((Table) event.getPersister().getMappedClass().getAnnotation(Table.class)).schema()
					+ "." + ((Table) event.getPersister().getMappedClass().getAnnotation(Table.class)).name());
		}
		super.onPostDelete(event);
	}
}
