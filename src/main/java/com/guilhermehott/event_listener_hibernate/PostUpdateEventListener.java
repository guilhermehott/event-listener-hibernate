package br.gov.funai.sgd.core.infra;

import javax.persistence.Table;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.ejb.event.EJB3PostUpdateEventListener;
import org.hibernate.event.spi.PostUpdateEvent;

import br.gov.funai.core.bean.entidade.Entidade;

public class PostUpdateEventListener extends EJB3PostUpdateEventListener {
	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(PostUpdateEventListener.class);

	@SuppressWarnings("unchecked")
	@Override
	public void onPostUpdate(PostUpdateEvent event) throws HibernateException {
		if (event.getEntity() instanceof Entidade) {
//			logger.info("onPostUpdate: entity : " + event.getEntity().getClass());
			logger.info("onPostUpdate: table: " 
					+ ((Table) event.getPersister().getMappedClass().getAnnotation(Table.class)).schema()
					+ "." + ((Table) event.getPersister().getMappedClass().getAnnotation(Table.class)).name());
		}
		super.onPostUpdate(event);
	}
}
