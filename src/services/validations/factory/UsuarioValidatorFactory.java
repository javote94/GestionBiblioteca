package services.validations.factory;

import dtos.UsuarioDTO;
import services.validations.EmailValidator;
import services.validations.NombreValidator;
import services.validations.NotNullValidator;
import services.validations.ValidatorExecutor;

public class UsuarioValidatorFactory {

    public static ValidatorExecutor<UsuarioDTO> create() {
        ValidatorExecutor<UsuarioDTO> executor = new ValidatorExecutor<>();

        executor.addValidatorToSave(new EmailValidator());
        executor.addValidatorToSave(new NombreValidator());

        executor.addValidatorToUpdate(new EmailValidator());
        executor.addValidatorToUpdate(new NombreValidator());

        return executor;
    }
}
