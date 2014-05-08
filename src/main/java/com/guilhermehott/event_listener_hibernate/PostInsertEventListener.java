package br.gov.funai.sgd.core.infra;

import javax.persistence.Table;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.ejb.event.EJB3PostInsertEventListener;
import org.hibernate.event.spi.PostInsertEvent;

import br.gov.funai.core.bean.entidade.Entidade;

public class PostInsertEventListener extends EJB3PostInsertEventListener {
	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(PostInsertEventListener.class);

	@SuppressWarnings("unchecked")
	@Override
	public void onPostInsert(PostInsertEvent event) throws HibernateException {
		if (event.getEntity() instanceof Entidade) {
//			logger.info("onPostInsert: entity : " + event.getEntity().getClass());
			logger.info("onPostInsert: table: " 
					+ ((Table) event.getPersister().getMappedClass().getAnnotation(Table.class)).schema()
					+ "." + ((Table) event.getPersister().getMappedClass().getAnnotation(Table.class)).name());
		}
		super.onPostInsert(event);
	}
}
