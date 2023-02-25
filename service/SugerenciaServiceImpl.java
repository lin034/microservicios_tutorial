package com.pildoraslin.aurrera.service;

import com.pildoraslin.aurrera.dto.SugerenciaDto;
import com.pildoraslin.aurrera.entidad.Cliente;
import com.pildoraslin.aurrera.entidad.Sugerencia;
import com.pildoraslin.aurrera.exepcion.RecursoNotFounException;
import com.pildoraslin.aurrera.exepcion.SugerenciaEditaException;
import com.pildoraslin.aurrera.repositorio.ClienteRepositorio;
import com.pildoraslin.aurrera.repositorio.SugerenciaRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SugerenciaServiceImpl implements SugerenciaService{

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ClienteRepositorio repositorioCliente;

    @Autowired
    SugerenciaRepositorio repositorio;

    @Override
    public List<SugerenciaDto> dameSugerencias() {

        List<Sugerencia> sugerencias = repositorio.findAll();

        List<SugerenciaDto> sugerenciasDto = sugerencias.stream().map( e -> cambiaAsugerenciaDto(e) ).collect(Collectors.toList());

        return sugerenciasDto;
    }

    @Override
    public List<SugerenciaDto> sugerenciaPorClienteId(int clienteId) {

       Cliente cliente =  repositorioCliente.findById(clienteId).orElseThrow(() -> new RecursoNotFounException("cliente" , "id", clienteId));


       List<Sugerencia> sugerencias = repositorio.findByClienteId(clienteId);



       List<SugerenciaDto> sugerenciasDto = sugerencias.stream().map(e -> cambiaAsugerenciaDto(e)).collect(Collectors.toList());

        return sugerenciasDto;
    }

    @Override
    public SugerenciaDto creaSugerencia(int clienteId, SugerenciaDto sugerenciaDto) {

        Cliente cliente = repositorioCliente.findById(clienteId).orElseThrow( () -> new RecursoNotFounException("cliente" , "id", clienteId));

        Sugerencia sugerencia = cambiaAsugerencia(sugerenciaDto);

        sugerencia.setCliente(cliente);

        repositorio.save(sugerencia);

        SugerenciaDto sugerenciaDto1 = cambiaAsugerenciaDto(sugerencia);

        return sugerenciaDto1;
    }

    @Override
    public SugerenciaDto editaSugerencia(int clienteId, int id, SugerenciaDto sugerenciaDto) {

        Cliente cliente = repositorioCliente.findById(clienteId).orElseThrow(() -> new RecursoNotFounException("cliente", "id", clienteId));

        Sugerencia sugerencia = repositorio.findById(id).orElseThrow(() -> new RecursoNotFounException("sugerencia", "id", id));

        if(cliente.getCliente_id() != sugerencia.getCliente().getCliente_id()){

            throw new SugerenciaEditaException( id, HttpStatus.BAD_REQUEST);
        }

        sugerencia.setDepartamento(sugerenciaDto.getDepartamento());
        sugerencia.setMensaje(sugerenciaDto.getMensaje());

        repositorio.save(sugerencia);

        SugerenciaDto sugerenciaDto1 = cambiaAsugerenciaDto(sugerencia);

        return sugerenciaDto1;
    }

    public SugerenciaDto cambiaAsugerenciaDto(Sugerencia sugerencia){

        SugerenciaDto sugerenciaDto = modelMapper.map(sugerencia, SugerenciaDto.class);

        return sugerenciaDto;
    }

    public Sugerencia cambiaAsugerencia(SugerenciaDto sugerenciaDto){

        Sugerencia sugerencia = modelMapper.map(sugerenciaDto, Sugerencia.class);


        return sugerencia;
    }
}
