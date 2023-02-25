package com.pildoraslin.aurrera.dto;

import com.pildoraslin.aurrera.entidad.Cliente;

public class SugerenciaDto {

    private int sugerencia_id;

    private String departamento;

    private String mensaje;

    private Cliente cliente;

    public SugerenciaDto() {
    }
                                                                //, Cliente cliente
    public SugerenciaDto(int sugerencia_id, String departamento, String mensaje, Cliente cliente) {
        this.sugerencia_id = sugerencia_id;
        this.departamento = departamento;
        this.mensaje = mensaje;
        this.cliente = cliente;
    }

    public int getSugerencia_id() {
        return sugerencia_id;
    }

    public void setSugerencia_id(int segerencia_id) {
        this.sugerencia_id = segerencia_id;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
