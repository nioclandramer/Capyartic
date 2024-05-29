package com.Capyapp.Capyartic.Excepciónes;

public class NivelEducativoNotFoundException extends RuntimeException{
    public NivelEducativoNotFoundException() {
        super();
    }

    public NivelEducativoNotFoundException(String message) {
        super(message);
    }

    public NivelEducativoNotFoundException(Throwable cause) {
        super(cause);
    }
}
