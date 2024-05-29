package com.Capyapp.Capyartic.Excepciónes;

public class SesionNotFoundException extends RuntimeException{
    public SesionNotFoundException() {
        super();
    }

    public SesionNotFoundException(String message) {
        super(message);
    }

    public SesionNotFoundException(Throwable cause) {
        super(cause);
    }
}
