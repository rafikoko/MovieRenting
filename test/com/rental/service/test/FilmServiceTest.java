package com.rental.service.test;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.rental.dao.FilmDao;
import com.rental.model.Film;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:resources/META-INF/spring-persistence-unit.xml", "file:resources/META-INF/services-context.xml"})
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=false)
@Transactional
public class FilmServiceTest {
	
	@Autowired
	FilmDao filmDao;
	
	@Test
	public void loadAll(){
		List<Film> films = filmDao.loadAll();
		Assert.assertNotNull(films);
		Assert.assertTrue(films.size()>0);
		
		for (Iterator iterator = films.iterator(); iterator.hasNext();) {
			Film film = (Film) iterator.next();
			System.out.println(film);
		}
	}
	
	@Test
	public void saveFilm(){
		Film newFilm = new Film();
		newFilm.setTitle("Test");
		newFilm.setDescription("Testing");
		newFilm.setFilmActors(null);
		newFilm.setFilmCategories(null);
		newFilm.setLanguageId(1);
		newFilm.setLastUpdate(new Timestamp((new Date()).getTime()));
		newFilm.setLength(125);
		newFilm.setRating("G");
		//newFilm.setReleaseYear(new Date());
		newFilm.setRentalRate(new BigDecimal(10.1));
		newFilm.setReplacementCost(new BigDecimal(50.1));
		newFilm.setSpecialFeatures("Trailers");
		filmDao.saveOrUpdate(newFilm);
		Assert.assertTrue(newFilm.getFilmId()>0);
		System.out.println("New film added with ID: " + newFilm.getFilmId());
	}
	
}
