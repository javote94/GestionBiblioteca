package com.academia.biblioteca.services.impl;

import com.academia.biblioteca.dao.IDao;
import com.academia.biblioteca.dtos.LibroDTO;
import com.academia.biblioteca.dtos.PrestamoDTO;
import com.academia.biblioteca.entities.Libro;
import com.academia.biblioteca.entities.Usuario;
import com.academia.biblioteca.services.PrestamoService;

public class PrestamoServiceImpl implements PrestamoService {

    private final IDao<Libro> libroDao;
    private final IDao<Usuario> usuarioDao;

    public PrestamoServiceImpl(IDao<Libro> libroDao, IDao<Usuario> usuarioDao) {
        this.libroDao = libroDao;
        this.usuarioDao = usuarioDao;
    }

    @Override
    public void prestarLibro(PrestamoDTO prestamoDTO) {
        Libro libro = libroDao.findById(prestamoDTO.getLibroDTO().getId())
                .orElseThrow(() -> new IllegalArgumentException("Libro no encontrado"));
        if (!libro.isDisponible()) {
            throw new IllegalArgumentException("El libro ya está prestado");
        }
        Usuario usuario = usuarioDao.findById(prestamoDTO.getUsuarioDTO().getId())
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));
        libro.setUsuario(usuario);
        libro.setDisponible(false);
        libroDao.update(libro);
    }

    @Override
    public void devolverLibro(LibroDTO libroDTO) {
        Libro libro = libroDao.findById(libroDTO.getId())
                .orElseThrow(() -> new IllegalArgumentException("Libro no encontrado"));
        if (libro.isDisponible()) {
            throw new IllegalArgumentException("El libro no está prestado");
        }
        libro.setUsuario(null);
        libro.setDisponible(true);
        libroDao.update(libro);
    }
}
