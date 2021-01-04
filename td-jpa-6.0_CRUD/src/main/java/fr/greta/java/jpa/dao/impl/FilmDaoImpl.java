package fr.greta.java.jpa.dao.impl;

import fr.greta.java.jpa.dao.FilmDao;
import fr.greta.java.jpa.entity.Film;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class FilmDaoImpl implements FilmDao {


    private EntityManager entityManager;

    public FilmDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //-------------------------------------------------
    @Override
    public Film find(int id) {
        return entityManager.find(Film.class, id);
    }

    @Override
    public List<Film> findAll() {
        TypedQuery<Film> query = entityManager.createQuery(
                "select f from Film f", Film.class);
        return query.getResultList();
    }

    @Override
    public Film create(Film obj) {
        entityManager.getTransaction().begin();
        entityManager.persist(obj);
        entityManager.getTransaction().commit();
        return obj;
    }

    @Override
    public Film update(Film obj) {
        entityManager.getTransaction().begin();
        entityManager.persist(obj);
        entityManager.getTransaction().commit();
        return obj;
    }

    @Override
    public void delete(Film obj) {
        entityManager.getTransaction().begin();
        entityManager.remove(obj);
        entityManager.getTransaction().commit();
    }
}
