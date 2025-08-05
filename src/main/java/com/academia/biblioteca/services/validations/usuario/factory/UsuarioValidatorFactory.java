package com.academia.biblioteca.services.validations.usuario.factory;

import com.academia.biblioteca.dtos.UsuarioDTO;
import com.academia.biblioteca.services.validations.*;
import com.academia.biblioteca.services.validations.usuario.*;

public class UsuarioValidatorFactory {

    public static ValidatorExecutor<UsuarioDTO> create() {
        ValidatorExecutor<UsuarioDTO> executor = new ValidatorExecutor<>();

        executor.addValidatorToSave(new EmailValidator());
        executor.addValidatorToSave(new NombreApellidoValidator());
        executor.addValidatorToSave(new UsuarioNotNullValidator());
        executor.addValidatorToSave(new UsuarioIdNullValidator());
        executor.addValidatorToSave(new DniValidator());
        executor.addValidatorToSave(new TelefonoValidator());

        executor.addValidatorToUpdate(new EmailValidator());
        executor.addValidatorToUpdate(new NombreApellidoValidator());
        executor.addValidatorToUpdate(new UsuarioNotNullValidator());
        executor.addValidatorToUpdate(new DniValidator());
        executor.addValidatorToUpdate(new TelefonoValidator());

        return executor;
    }
}
