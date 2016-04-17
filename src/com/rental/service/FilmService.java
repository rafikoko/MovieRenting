package com.rental.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Service;

import com.rental.model.Film;

@Service
public class FilmService {
	EntityManagerFactory emf;
	private EntityManager getEntityManager() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("usersPU");
        }
        return emf.createEntityManager();
    }
 
    @SuppressWarnings("unchecked")
	public List<Film> getFilms() {
        EntityManager em = getEntityManager();
        try {
            javax.persistence.Query q = em.createNamedQuery("Film.findAll");
            return q.getResultList();
        } finally {
            em.close();
        }
    }
}
