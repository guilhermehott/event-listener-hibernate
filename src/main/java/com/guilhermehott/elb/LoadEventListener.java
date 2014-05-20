package com.guilhermehott.elb;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.event.internal.DefaultLoadEventListener;
import org.hibernate.event.spi.LoadEvent;

public class LoadEventListener extends DefaultLoadEventListener {
	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(LoadEventListener.class);
	
	private static LoadEvent ultimoLoadEvent;
	
	public LoadEventListener(){
		super();
	}

	@Override
	public void onLoad(LoadEvent event, org.hibernate.event.spi.LoadEventListener.LoadType loadType) throws HibernateException {
		if (ultimoLoadEvent != event) {
			ultimoLoadEvent = event;
//			logger.info("onPostLoad: entity : " + event.getEntity().getClass());
			System.out.println("onLoad: table: " 
					+ event.getEntityClassName());
		}
//		logger.info("testeeee");
		// logger.info("onPostLoad:  loading object for event " + event
		// + " and loadType " + loadType);
		// logger.info("onPostLoad: getEntityId : " + event.getId());
		// logger.info("onPostLoad: getLockMode - " + event.getLockMode());
		// logger.info("onPostLoad: getSession - " + event.getSession());
		// logger.info("onPostLoad: getResult - " + event.getResult());
//		super.onLoad(event, loadType);
	}
}
