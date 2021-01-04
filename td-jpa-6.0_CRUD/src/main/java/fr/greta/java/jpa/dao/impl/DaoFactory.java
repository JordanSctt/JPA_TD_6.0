package fr.greta.java.jpa.dao.impl;

import fr.greta.java.jpa.dao.FilmDao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DaoFactory {

    private static FilmDao filmDao;
    private static String PERSISTENCE = "jpa-unit";
    private static EntityManagerFactory entityFactory = Persistence.createEntityManagerFactory(PERSISTENCE);

    public static FilmDao createFilmDao() {
        if(filmDao == null){
            filmDao = new FilmDaoImpl(entityFactory.createEntityManager());
        }
        return filmDao;
    }

}
