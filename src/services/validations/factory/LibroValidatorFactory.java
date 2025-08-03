package services.validations.factory;

import dtos.LibroDTO;
import services.validations.*;

public class LibroValidatorFactory {

    public static ValidatorExecutor<LibroDTO> create() {

        ValidatorExecutor<LibroDTO> executor = new ValidatorExecutor<>();

        executor.addValidatorToSave(new NotNullValidator());
        executor.addValidatorToSave(new IdNullValidator());
        executor.addValidatorToSave(new TituloValidator());
        executor.addValidatorToSave(new AutorValidator());
        executor.addValidatorToSave(new AnioPublicacionValidator());

        executor.addValidatorToUpdate(new NotNullValidator());
        executor.addValidatorToUpdate(new TituloValidator());
        executor.addValidatorToUpdate(new AutorValidator());
        executor.addValidatorToUpdate(new AnioPublicacionValidator());

        return executor;
    }
}
