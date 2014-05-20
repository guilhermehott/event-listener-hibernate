package com.guilhermehott.elb;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.ejb.event.EJB3PersistEventListener;
import org.hibernate.event.spi.PersistEvent;

public class PostInsertEventListener extends EJB3PersistEventListener {
	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(PostInsertEventListener.class);

	@Override
	public void onPersist(PersistEvent event) throws HibernateException {
//			logger.info("onPostInsert: entity : " + event.getEntity().getClass());
			System.out.println("onPersist: table: " 
					+ event.getEntityName());
		super.onPersist(event);
	}
	
}
