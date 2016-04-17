package com.rental.dao;

import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Service;

import com.rental.model.Actor;

@Service
public class ActorDao extends GeneralDao {

	public Actor load(final int id){
		return getHibernateTemplate().execute(new HibernateCallback<Actor>() {

			@Override
			public Actor doInHibernate(Session session) throws HibernateException,
					SQLException {
				Query query = session.createQuery("from Actor a where a.actorId = :id");
				query.setParameter("id", id);
				Actor a = (Actor) query.uniqueResult();
				return a;
			}
		});
	}
}
