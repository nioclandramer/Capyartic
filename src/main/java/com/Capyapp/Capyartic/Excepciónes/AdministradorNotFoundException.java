package com.Capyapp.Capyartic.Excepciónes;

public class AdministradorNotFoundException extends RuntimeException {
    public AdministradorNotFoundException() {
        super();
    }
    public AdministradorNotFoundException(String message) {
        super(message);
    }
    public AdministradorNotFoundException(Throwable cause) {
        super(cause);
    }
}
