package fr.greta.java.jpa;

import fr.greta.java.jpa.dao.FilmDao;
import fr.greta.java.jpa.dao.impl.DaoFactory;
import fr.greta.java.jpa.entity.Film;

import java.util.List;

public class RunnerTdJpa8 {

    public static void main(String[] args) {

        FilmDao filmDao = DaoFactory.createFilmDao();

        Film film1 = new Film();
        film1.setTitle("Interstellar");
        film1.setAuthor("James Camerron");
        filmDao.create(film1);

        Film film2 = new Film();
        film2.setTitle("Retour vers le futur");
        film2.setAuthor("Benoit Stancks");
        filmDao.create(film2);

        Film film3 = new Film();
        film3.setTitle("Ligne verte");
        film3.setAuthor("Henry Dellor");
        filmDao.create(film3);

        Film film4 = new Film();
        film4.setTitle("Tenet");
        film4.setAuthor("James Camerron");
        filmDao.create(film4);

        Film film5 = new Film();
        film5.setTitle("Les visiteurs");
        film5.setAuthor("Alain Terzian");
        filmDao.create(film5);

        Film film6 = new Film();
        film6.setTitle("Thor");
        film6.setAuthor("Marvel Studio");
        filmDao.create(film6);

        Film film7 = new Film();
        film7.setTitle("Captain america");
        film7.setAuthor("Marvel Studio");
        filmDao.create(film7);


        List<Film> findAll = filmDao.findAll();
        System.out.println("Tous les films:");
        for(Film film : findAll) {
            System.out.println(film.getTitle() + " - " + film.getAuthor());
        }

        Film find5 = filmDao.find(5);
        System.out.println("un film: " + find5.getTitle() + " - where id = " + find5.getId());
    }

}
