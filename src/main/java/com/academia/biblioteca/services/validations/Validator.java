package com.academia.biblioteca.services.validations;

public interface Validator<T> {
    void validate(T dto);
}
