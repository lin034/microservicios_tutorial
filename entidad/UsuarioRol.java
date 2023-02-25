package com.pildoraslin.aurrera.entidad;


import jakarta.persistence.*;

@Entity
@Table(name = "usuario_role")
public class UsuarioRol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_rol_id")
    private int usuario_rol_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private  Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rol_id", nullable = false)
    private Rol rol;

    @Column(name = "comentario")
    private String comentario;

    public UsuarioRol() {
    }

    public UsuarioRol(Usuario usuario, Rol rol, String comenteario) {
        this.usuario = usuario;
        this.rol = rol;
        this.comentario = comenteario;
    }

    public int getUsuario_rol_id() {
        return usuario_rol_id;
    }

    public void setUsuario_rol_id(int usuario_rol_id) {
        this.usuario_rol_id = usuario_rol_id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public String getComenteario() {
        return comentario;
    }

    public void setComenteario(String comenteario) {
        this.comentario = comenteario;
    }
}
