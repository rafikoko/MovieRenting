package com.rental.dao;

import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;

import com.rental.model.Base;

@Service
public class GeneralDao extends HibernateDaoSupport {
	
	@Autowired
	@Qualifier("sessionFactory")
	public void init(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
	
	public void saveOrUpdate(final Base modelObject) {
		getHibernateTemplate().execute(new HibernateCallback<Boolean>() {@Override
		public Boolean doInHibernate(Session session) throws HibernateException,
				SQLException {
			session.saveOrUpdate(modelObject);
			
			return true;
		}
		});
	}
	
}
