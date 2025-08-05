package com.academia.biblioteca.controllers;

public class ApiResponse<T> {

    private int statusCode;
    private T data;
    private Exception error;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Exception getError() {
        return error;
    }

    public void setError(Exception error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "ApiResponse{" +
               "statusCode=" + statusCode +
               ", data=" + data +
               ", error=" + error +
               '}';
    }
}
