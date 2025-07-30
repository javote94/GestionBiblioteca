package controllers;

import dtos.LibroDTO;

public class ApiResponse {
    private int statusCode;
    private LibroDTO[] data;
    private RuntimeException error;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public LibroDTO[] getData() {
        return data;
    }

    public void setData(LibroDTO[] data) {
        this.data = data;
    }

    public RuntimeException getError() {
        return error;
    }

    public void setError(RuntimeException error) {
        this.error = error;
    }
}
