package com.Capyapp.Capyartic.Excepciónes;

public class TutorNotFoundException extends RuntimeException{
    public TutorNotFoundException() {
        super();
    }

    public TutorNotFoundException(String message) {
        super(message);
    }

    public TutorNotFoundException(Throwable cause) {
        super(cause);
    }
}
