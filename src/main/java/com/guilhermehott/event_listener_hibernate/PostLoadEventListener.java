package br.gov.funai.sgd.core.infra;

import javax.persistence.Table;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.ejb.event.EJB3PostLoadEventListener;
import org.hibernate.event.spi.PostLoadEvent;

import br.gov.funai.core.bean.entidade.Entidade;

public class PostLoadEventListener extends EJB3PostLoadEventListener {
	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(PostLoadEventListener.class);
	
	private static PostLoadEvent ultimoPostLoadEvent;

	@SuppressWarnings("unchecked")
	@Override
	public void onPostLoad(PostLoadEvent event) throws HibernateException {
		if (event.getEntity() instanceof Entidade && ultimoPostLoadEvent != event) {
			ultimoPostLoadEvent = event;
//			logger.info("onPostLoad: entity : " + event.getEntity().getClass());
			logger.info("onPostLoad: table: " 
					+ ((Table) event.getPersister().getMappedClass().getAnnotation(Table.class)).schema() + "."
					+ ((Table) event.getPersister().getMappedClass().getAnnotation(Table.class)).name());
		}
		// logger.info("onPostLoad:  loading object for event " + event
		// + " and loadType " + loadType);
		// logger.info("onPostLoad: getEntityId : " + event.getId());
		// logger.info("onPostLoad: getLockMode - " + event.getLockMode());
		// logger.info("onPostLoad: getSession - " + event.getSession());
		// logger.info("onPostLoad: getResult - " + event.getResult());
		super.onPostLoad(event);
	}
}
