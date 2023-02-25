package com.pildoraslin.aurrera.controlador;

import com.pildoraslin.aurrera.dto.ClienteDto;
import com.pildoraslin.aurrera.dto.SugerenciaDto;
import com.pildoraslin.aurrera.service.SugerenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SugerenciaControlador {

//ola desde git lin

    @Autowired
    SugerenciaService dao;

    @GetMapping("/clientes/sugerencias")
    public List<SugerenciaDto> dameSugerencias() {

        return dao.dameSugerencias();
    }

    @GetMapping("/clientes/{clienteId}/sugerencias")
    public List<SugerenciaDto> sugerenciaPorClienteId(@PathVariable(name = "clienteId") int clienteId) {

        return dao.sugerenciaPorClienteId(clienteId);
    }

    @PostMapping("/clientes/{clienteId}/sugerencias")
    public SugerenciaDto creaSugerencia(@PathVariable(value = "clienteId") int clienteId, @RequestBody SugerenciaDto sugerenciaDto) {

        return  dao.creaSugerencia(clienteId, sugerenciaDto);
    }

    @PutMapping("/clientes/{clienteId}/sugerencias/{id}")
    public SugerenciaDto editaSugerencia(@PathVariable(name = "clienteId") int clienteId, @PathVariable(name="id") int id, @RequestBody SugerenciaDto sugerenciaDto){

        return dao.editaSugerencia(clienteId, id, sugerenciaDto);
    }

}
