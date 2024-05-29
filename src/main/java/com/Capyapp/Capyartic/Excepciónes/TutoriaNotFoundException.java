package com.Capyapp.Capyartic.Excepciónes;

public class TutoriaNotFoundException extends RuntimeException{
    public TutoriaNotFoundException() {
        super();
    }

    public TutoriaNotFoundException(String message) {
        super(message);
    }

    public TutoriaNotFoundException(Throwable cause) {
        super(cause);
    }
}
