package fr.greta.java.jpa;


import fr.greta.java.jpa.dao.FilmDao;
import fr.greta.java.jpa.dao.impl.DaoFactory;
import fr.greta.java.jpa.entity.Film;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/film")
public class FilmServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FilmDao filmDao = DaoFactory.createFilmDao();

        PrintWriter out = resp.getWriter();

        List<Film> films = filmDao.findAll();
        if(films.isEmpty()) {
            initFilms(filmDao);
            films = filmDao.findAll();
        }

        for(Film film : films) {
            out.println("Film: " + film.getTitle() + " - " + film.getAuthor());
        }
    }

    private void initFilms(FilmDao filmDao) {
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
    }
}
