package com.Capyapp.Capyartic.Excepciónes;

public class TemaNotFoundException extends RuntimeException{
    public TemaNotFoundException() {
        super();
    }

    public TemaNotFoundException(String message) {
        super(message);
    }

    public TemaNotFoundException(Throwable cause) {
        super(cause);
    }
}
