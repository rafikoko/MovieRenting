package com.rental.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Service;

import com.rental.model.Film;

@Service
public class FilmDao extends GeneralDao {

	private static transient Logger LOG = LoggerFactory.getLogger(FilmDao.class);

	public Film load(final int id) {
		return getHibernateTemplate().execute(new HibernateCallback<Film>() {
			public Film doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery("from Film f where f.filmId = :id");
				query.setParameter("id", id);
				Film film = (Film) query.uniqueResult();
				return film;
			}
		});
	};

	public List<Film> loadAll() {
		return getHibernateTemplate().execute(new HibernateCallback<List<Film>>() {
			public List<Film> doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery("from Film f order by upper(f.title) ");
				@SuppressWarnings("unchecked")
				List<Film> films = query.list();
				return films;
			}
		});
	};
	
	public void saveOrUpdate(final Film film) {
		getHibernateTemplate().execute(new HibernateCallback<Boolean>() {
			@Override
		public Boolean doInHibernate(Session session) throws HibernateException,
				SQLException {
			session.saveOrUpdate(film);
			
			return true;
		}
		});
	}

		
	public void remove(int id, String modifiedBy) {
		Film film = load(id);
		
		getHibernateTemplate().delete(film);
	};

}