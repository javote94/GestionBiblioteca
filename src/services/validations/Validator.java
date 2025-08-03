package services.validations;

import dtos.LibroDTO;

public interface Validator<T> {
    void validate(T dto);
}
