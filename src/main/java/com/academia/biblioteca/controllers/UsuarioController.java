package com.academia.biblioteca.controllers;

import com.academia.biblioteca.dtos.UsuarioDTO;
import com.academia.biblioteca.services.UsuarioService;

import java.util.List;

public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    public ApiResponse<UsuarioDTO> postUsuario(UsuarioDTO usuarioDto) {
        ApiResponse<UsuarioDTO> response = new ApiResponse<>();
        try {
            UsuarioDTO usuarioDTO = service.save(usuarioDto);
            response.setStatusCode(201);
            response.setData(usuarioDTO);
        } catch (IllegalArgumentException e) {
            response.setStatusCode(400);
            response.setError(e);
        }
        return response;
    }

    public ApiResponse<Void> putUsuario(UsuarioDTO usuarioDto) {
        ApiResponse<Void> response = new ApiResponse<>();
        try {
            service.update(usuarioDto);
            response.setStatusCode(200);
        } catch (IllegalArgumentException e) {
            response.setStatusCode(400);
            response.setError(e);
        }
        return response;
    }

    public ApiResponse<Void> deleteUsuario(Long id) {
        ApiResponse<Void> response = new ApiResponse<>();
        try {
            service.delete(id);
            response.setStatusCode(204); // No Content
        } catch (IllegalArgumentException e) {
            response.setStatusCode(400);
            response.setError(e);
        }
        return response;
    }

    public ApiResponse<UsuarioDTO> getUsuario(Long id) {
        ApiResponse<UsuarioDTO> response = new ApiResponse<>();
        try {
            UsuarioDTO usuarioDTO = service.findById(id);
            response.setStatusCode(200);
            response.setData(usuarioDTO);
        } catch (IllegalArgumentException e) {
            response.setStatusCode(400);
            response.setError(e);
        }
        return response;
    }

public ApiResponse<List<UsuarioDTO>> getAllUsuarios() {
        ApiResponse<List<UsuarioDTO>> response = new ApiResponse<>();
        try {
            List<UsuarioDTO> usuarios = service.findAll();
            response.setStatusCode(200);
            response.setData(usuarios);
        } catch (Exception e) {
            response.setStatusCode(500);
            response.setError(e);
        }
        return response;
    }
}
