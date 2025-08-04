package services.validations.libro.factory;

import dtos.LibroDTO;
import services.validations.*;
import services.validations.libro.*;

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
