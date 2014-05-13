package com.guilhermehott.elb;

import javax.persistence.Table;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.ejb.event.EJB3PostDeleteEventListener;
import org.hibernate.event.spi.PostDeleteEvent;

public class PostDeleteEventListener extends EJB3PostDeleteEventListener {
	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(PostDeleteEventListener.class);

	@SuppressWarnings("unchecked")
	@Override
	public void onPostDelete(PostDeleteEvent event) throws HibernateException {
//			logger.info("onPostDelete: entity : " + event.getEntity().getClass());
			logger.info("onPostDelete: table: " 
					+ ((Table) event.getPersister().getMappedClass().getAnnotation(Table.class)).schema()
					+ "." + ((Table) event.getPersister().getMappedClass().getAnnotation(Table.class)).name());
		super.onPostDelete(event);
	}
}
