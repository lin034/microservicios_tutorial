package com.pildoraslin.aurrera.entidad;

import jakarta.persistence.*;

@Entity
@Table(name = "sugerencia")
public class Sugerencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sugerencia_id")
    private int sugerencia_id;

    @Column(name = "departamento")
    private String departamento;

    @Column(name = "mensaje")
    private String mensaje;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="cliente_id", nullable = false)
    private Cliente cliente;

    public Sugerencia() {

    }

    public Sugerencia(String departamento, String mensaje, Cliente cliente) {
        this.departamento = departamento;
        this.mensaje = mensaje;
        this.cliente = cliente;
    }

    public int getSugerencia_id() {
        return sugerencia_id;
    }

    public void setSugerencia_id(int sugerencia_id) {
        this.sugerencia_id = sugerencia_id;
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
