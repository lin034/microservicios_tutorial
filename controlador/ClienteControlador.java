package com.pildoraslin.aurrera.controlador;


import com.pildoraslin.aurrera.dto.ClienteDto;
import com.pildoraslin.aurrera.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteControlador {

    @Autowired
    ClienteService dao;


    //@PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/clientes")
    public List<ClienteDto> dameClientes(){

        return dao.dameClientes();
    }

    @GetMapping("/clientes/{clienteId}")
    public ClienteDto dameCliente(@PathVariable(name = "clienteId") int clienteId){

        return dao.dameCliente(clienteId);
    }


    @PreAuthorize("hasRole('rolAdmin')")
    @PostMapping("/clientes")
    public ClienteDto creaCliente(@Valid @RequestBody ClienteDto clienteDto){

        return dao.creaCliente(clienteDto);
    }

    @PreAuthorize("hasRole('rolAdmin')")
    @DeleteMapping("/clientes/{id}")
    public ResponseEntity<String> eliminaCliente(@PathVariable(name = "id") int id){

        dao.eliminaCliente(id);

        return new ResponseEntity<>("cliente eliminado con exito", HttpStatus.ACCEPTED);
    }

    @PreAuthorize("hasRole('rolAdmin')")
    @PutMapping("/clientes/{id}")
    public ClienteDto editaCliente(@PathVariable(name = "id") int id,@Valid  @RequestBody ClienteDto clienteDto){

        return dao.editaCliente(id, clienteDto);
    }

}
