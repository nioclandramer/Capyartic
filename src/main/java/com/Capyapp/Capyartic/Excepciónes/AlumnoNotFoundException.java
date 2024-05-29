package com.Capyapp.Capyartic.Excepciónes;

public class AlumnoNotFoundException extends RuntimeException{
    public AlumnoNotFoundException(){
        super();
    }
    public AlumnoNotFoundException(String message){
        super(message);
    }

    public AlumnoNotFoundException(Throwable cause) {
        super(cause);
    }
}
