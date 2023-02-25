package com.pildoraslin.aurrera.exepcion;

import org.springframework.http.HttpStatus;

public class SugerenciaEditaException extends RuntimeException{

    private HttpStatus sugerenciaEditaStatus;

    private int sugerenciaId;

    public SugerenciaEditaException(int sugerenciaId, HttpStatus sugerenciaEditaStatus) {
        super(String.format("la sugerencia numero '%s' no pertenece al cliente, intente de nuevo", sugerenciaId));
        this.sugerenciaEditaStatus = sugerenciaEditaStatus;
        this.sugerenciaId = sugerenciaId;
    }

    public HttpStatus getSugerenciaEditaStatus() {
        return sugerenciaEditaStatus;
    }

    public void setSugerenciaEditaStatus(HttpStatus sugerenciaEditaStatus) {
        this.sugerenciaEditaStatus = sugerenciaEditaStatus;
    }

    public int getSugerenciaId() {
        return sugerenciaId;
    }

    public void setSugerenciaId(int sugerenciaId) {
        this.sugerenciaId = sugerenciaId;
    }
}
