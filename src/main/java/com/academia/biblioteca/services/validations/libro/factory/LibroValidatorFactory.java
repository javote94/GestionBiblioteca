package com.academia.biblioteca.services.validations.libro.factory;

import com.academia.biblioteca.dtos.LibroDTO;
import com.academia.biblioteca.services.validations.*;
import com.academia.biblioteca.services.validations.libro.*;

public class LibroValidatorFactory {

    public static ValidatorExecutor<LibroDTO> create() {

        ValidatorExecutor<LibroDTO> executor = new ValidatorExecutor<>();

        executor.addValidatorToSave(new LibroNotNullValidator());
        executor.addValidatorToSave(new LibroIdNullValidator());
        executor.addValidatorToSave(new TituloValidator());
        executor.addValidatorToSave(new AutorValidator());
        executor.addValidatorToSave(new AnioPublicacionValidator());

        executor.addValidatorToUpdate(new LibroNotNullValidator());
        executor.addValidatorToUpdate(new TituloValidator());
        executor.addValidatorToUpdate(new AutorValidator());
        executor.addValidatorToUpdate(new AnioPublicacionValidator());

        return executor;
    }
}
