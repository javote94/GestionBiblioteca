package services.validations;

import dtos.LibroDTO;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class LibroValidatorExecutor {

    private static final Set<ValidatorToSave> validatorsToSave = new LinkedHashSet<>();
    private static final Set<ValidatorToUpdate> validatorsToUpdate = new LinkedHashSet<>();

    static {
        validatorsToSave.add(new NotNullValidator());
        validatorsToSave.add(new IdValidator());
        validatorsToSave.add(new TituloValidator());
        validatorsToSave.add(new AutorValidator());
        validatorsToSave.add(new AnioPublicacionValidator());

        validatorsToUpdate.add(new NotNullValidator());
        validatorsToUpdate.add(new TituloValidator());
        validatorsToUpdate.add(new AutorValidator());
        validatorsToUpdate.add(new AnioPublicacionValidator());
    }

    public static void validateToSave(LibroDTO libroDTO) {
        validatorsToSave.forEach(validator -> validator.validate(libroDTO));
    }

    public static void validateToUpdate(LibroDTO libroDTO) {
        validatorsToUpdate.forEach(validator -> validator.validate(libroDTO));
    }
}
