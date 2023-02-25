package com.pildoraslin.aurrera.repositorio;

import com.pildoraslin.aurrera.entidad.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Integer> {


}
