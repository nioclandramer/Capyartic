package com.Capyapp.Capyartic.Excepciónes;

public class CategoriaNotFoundException extends RuntimeException{
    public CategoriaNotFoundException() {
        super();
    }

    public CategoriaNotFoundException(String message) {
        super(message);
    }

    public CategoriaNotFoundException(Throwable cause) {
        super(cause);
    }
}
