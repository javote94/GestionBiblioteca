package services.impl;

import dao.IDao;
import dtos.LibroDTO;
import dtos.UsuarioDTO;
import entities.Libro;
import entities.Usuario;
import services.UsuarioService;
import services.mappers.UsuarioMapper;
import services.validations.ValidatorExecutor;
import services.validations.factory.UsuarioValidatorFactory;

import java.util.List;
import java.util.Optional;

public class UsuarioServiceImpl implements UsuarioService {

    private final IDao<Usuario> dao;
    private final ValidatorExecutor<UsuarioDTO> validatorExecutor;

    public UsuarioServiceImpl(IDao<Usuario> dao) {
        this.dao = dao;
        this.validatorExecutor = UsuarioValidatorFactory.create();
    }

    @Override
    public void save(UsuarioDTO usuarioDTO) {
        validatorExecutor.validateToSave(usuarioDTO);
        Usuario usuario = UsuarioMapper.toEntity(usuarioDTO);
        dao.save(usuario);
    }

    @Override
    public void update(UsuarioDTO usuarioDTO) {
        validateId(usuarioDTO.getId());
        validatorExecutor.validateToUpdate(usuarioDTO);
        Usuario usuarioExistente = getUsuarioById(usuarioDTO.getId());
        usuarioExistente.setNombre(usuarioDTO.getNombre());
        usuarioExistente.setApellido(usuarioDTO.getApellido());
        usuarioExistente.setDni(usuarioDTO.getDni());
        usuarioExistente.setEmail(usuarioDTO.getEmail());
        usuarioExistente.setTelefono(usuarioDTO.getTelefono());
        dao.update(usuarioExistente);
    }

    @Override
    public void delete(Long id) {
        validateId(id);
        getUsuarioById(id);
        dao.delete(id);
    }

    @Override
    public UsuarioDTO findById(Long id) {
        validateId(id);
        Usuario usuario = getUsuarioById(id);
        return UsuarioMapper.toDTO(usuario);
    }

    @Override
    public List<UsuarioDTO> findAll() {
        List<Usuario> usuarios = dao.findAll();
        if (usuarios.isEmpty()) {
            throw new IllegalArgumentException("No se encontraron usuarios en la base de datos");
        }
        return usuarios.stream()
                .map(UsuarioMapper::toDTO)
                .toList();
    }

    private void validateId(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("El ID proporcionado no es válido");
        }
    }

    private Usuario getUsuarioById(Long id) {
        Optional<Usuario> usuarioOptional = dao.findById(id);
        if (usuarioOptional.isEmpty()) {
            throw new IllegalArgumentException("No se encontró el usuario con el ID proporcionado");
        }
        return usuarioOptional.get();
    }
}
