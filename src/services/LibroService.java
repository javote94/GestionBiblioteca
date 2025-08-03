package services;

import dtos.LibroDTO;
import dtos.UsuarioDTO;
import java.util.List;

public interface LibroService {

    void save(LibroDTO libroDTO);
    void update(LibroDTO libroDTO);
    void delete(Long id);
    LibroDTO findById(Long id);
    List<LibroDTO> findAll();
}
