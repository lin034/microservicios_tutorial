package com.pildoraslin.aurrera.dto;

import com.pildoraslin.aurrera.entidad.Sugerencia;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

public class ClienteDto {


    private int cliente_id;

    @NotEmpty
    @Size(min=2, message = "minimo 12 letras en el nombre")
    private String nombre;

    @NotEmpty
    @Size(min=2, message = "minimo 12 letras en el apellido")
    private String apellido;

    @NotEmpty
    @Size(min=2, message = "el email deberia tener al menos 12 caracteres")
    private String email;

    public List<Sugerencia> getSugerencias() {
        return sugerencias;
    }

    public void setSugerencias(List<Sugerencia> sugerencias) {
        this.sugerencias = sugerencias;
    }

    private List<Sugerencia> sugerencias = new ArrayList<>();

    public ClienteDto() {
    }

    public int getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
