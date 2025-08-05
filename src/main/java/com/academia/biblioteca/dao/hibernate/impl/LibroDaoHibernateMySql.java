package com.academia.biblioteca.dao.hibernate.impl;

import com.academia.biblioteca.dao.IDao;
import com.academia.biblioteca.dao.hibernate.HibernateUtil;
import com.academia.biblioteca.entities.Libro;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.util.List;
import java.util.Optional;

public class LibroDaoHibernateMySql implements IDao<Libro> {

    private final SessionFactory sessionFactory;

    public LibroDaoHibernateMySql() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public Libro save(Libro libro) {
        try(Session session = sessionFactory.openSession()){
            session.beginTransaction();
            session.save(libro);
            session.getTransaction().commit();
            return libro;
        } catch (Exception e) {
            throw new RuntimeException("Error al guardar el libro en la base de datos", e);
        }
    }

    @Override
    public void update(Libro libro) {
        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(libro);
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException("Error al actualizar el libro en la base de datos", e);
        }
    }

    @Override
    public void delete(Long id) {
        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Libro libro = session.get(Libro.class, id);
            if (libro != null) {
                session.delete(libro);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException("Error al eliminar el libro de la base de datos", e);
        }
    }

    @Override
    public Optional<Libro> findById(Long id) {
        try(Session session = sessionFactory.openSession()) {
            Libro libro = session.get(Libro.class, id);
            return Optional.ofNullable(libro);
        } catch (Exception e) {
            throw new RuntimeException("Error al buscar el libro en la base de datos", e);
        }
    }

    @Override
    public List<Libro> findAll() {
        try(Session session = sessionFactory.openSession()) {
            return session.createQuery("from Libro", Libro.class).list();
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener la lista de libros de la base de datos", e);
        }
    }
}
