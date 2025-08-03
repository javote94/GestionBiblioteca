package services.validations;

import dtos.LibroDTO;
import java.util.LinkedHashSet;
import java.util.Set;

public class ValidatorExecutor<T> {

    private final Set<ValidatorToSave<T>> validatorsToSave = new LinkedHashSet<>();
    private final Set<ValidatorToUpdate<T>> validatorsToUpdate = new LinkedHashSet<>();

    public void addValidatorToSave(ValidatorToSave<T> validator) {
        validatorsToSave.add(validator);
    }

    public void addValidatorToUpdate(ValidatorToUpdate<T> validator) {
        validatorsToUpdate.add(validator);
    }

    public void validateToSave(T dto) {
        validatorsToSave.forEach(v -> v.validate(dto));
    }

    public void validateToUpdate(T dto) {
        validatorsToUpdate.forEach(v -> v.validate(dto));
    }
}
