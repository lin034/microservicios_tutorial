package com.pildoraslin.aurrera.exepcion;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class RecursoNotFounException extends RuntimeException {

    private String entidadError;

    private String campoError;

    private int valorCampoError;

    public RecursoNotFounException(String entidadError, String campoError, int valorCampoError) {
        super(String.format("%s con %s: '%s' no existe intenta otra vez ", entidadError, campoError, valorCampoError));
        this.entidadError = entidadError;
        this.campoError = campoError;
        this.valorCampoError = valorCampoError;
    }
}
