package com.academia.biblioteca.dao.hibernate.impl;

import com.academia.biblioteca.dao.IDao;
import com.academia.biblioteca.dao.hibernate.HibernateUtil;
import com.academia.biblioteca.entities.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Optional;

public class UsuarioDaoHibernateMySql implements IDao<Usuario> {

    private final SessionFactory sessionFactory;

    public UsuarioDaoHibernateMySql() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public Usuario save(Usuario usuario) {
        try(Session session = sessionFactory.openSession()){
            session.beginTransaction();
            session.save(usuario);
            session.getTransaction().commit();
            return usuario;
        } catch (Exception e) {
            throw new RuntimeException("Error al guardar el usuario en la base de datos", e);
        }
    }

    @Override
    public void update(Usuario usuario) {
        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(usuario);
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException("Error al actualizar el usuario en la base de datos", e);
        }
    }

    @Override
    public void delete(Long id) {
        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Usuario usuario = session.get(Usuario.class, id);
            if (usuario != null) {
                session.delete(usuario);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException("Error al eliminar el usuario de la base de datos", e);
        }
    }

    @Override
    public Optional<Usuario> findById(Long id) {
        try(Session session = sessionFactory.openSession()) {
            Usuario usuario = session.get(Usuario.class, id);
            return Optional.ofNullable(usuario);
        } catch (Exception e) {
            throw new RuntimeException("Error al buscar el usuario por ID en la base de datos", e);
        }
    }

    @Override
    public List<Usuario> findAll() {
        try(Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Usuario", Usuario.class).list();
        } catch (Exception e) {
            throw new RuntimeException("Error al buscar todos los usuarios en la base de datos", e);
        }
    }
}
