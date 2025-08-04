package services.impl;

import dao.IDao;
import dtos.PrestamoDTO;
import entities.Libro;
import entities.Usuario;
import services.PrestamoService;

public class PrestamoServiceImpl implements PrestamoService {

    private final IDao<Libro> libroDao;
    private final IDao<Usuario> usuarioDao;

    public PrestamoServiceImpl(IDao<Libro> libroDao, IDao<Usuario> usuarioDao) {
        this.libroDao = libroDao;
        this.usuarioDao = usuarioDao;
    }

    @Override
    public void prestarLibro(PrestamoDTO prestamoDTO) {
        Libro libro = libroDao.findById(prestamoDTO.getLibroId())
                .orElseThrow(() -> new IllegalArgumentException("Libro no encontrado"));
        if (!libro.isDisponible()) {
            throw new IllegalArgumentException("El libro ya está prestado");
        }
        usuarioDao.findById(prestamoDTO.getUsuarioId())
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));
        libro.setUsuarioId(prestamoDTO.getUsuarioId());
        libro.setDisponible(false);
        libroDao.update(libro);
    }

    @Override
    public void devolverLibro(Long libroId) {
        Libro libro = libroDao.findById(libroId)
                .orElseThrow(() -> new IllegalArgumentException("Libro no encontrado"));
        if (libro.isDisponible()) {
            throw new IllegalArgumentException("El libro no está prestado");
        }
        libro.setUsuarioId(null);
        libro.setDisponible(true);
        libroDao.update(libro);
    }
}
