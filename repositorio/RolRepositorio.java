package com.pildoraslin.aurrera.repositorio;

import com.pildoraslin.aurrera.entidad.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RolRepositorio extends JpaRepository<Rol, Integer> {

    public Optional<Rol> findByNombre(String nombre);
}
