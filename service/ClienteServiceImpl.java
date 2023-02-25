package com.pildoraslin.aurrera.service;

import com.pildoraslin.aurrera.dto.ClienteDto;
import com.pildoraslin.aurrera.entidad.Cliente;
import com.pildoraslin.aurrera.exepcion.RecursoNotFounException;
import com.pildoraslin.aurrera.repositorio.ClienteRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ClienteRepositorio repositorio;

    @Override
    public List<ClienteDto> dameClientes() {

        List<Cliente> clientes = repositorio.findAll();
        List<ClienteDto> clientesDto = clientes.stream().map(e -> cambiarAclienteDto(e)).collect(Collectors.toList());



        return clientesDto;
    }

    @Override
    public ClienteDto dameCliente(int clienteId) {

        Cliente cliente = repositorio.findById(clienteId).orElseThrow( () -> new RecursoNotFounException("cliente", "id", clienteId));

        ClienteDto clienteDto = cambiarAclienteDto(cliente);

        return clienteDto;
    }

    @Override
    public ClienteDto creaCliente(ClienteDto clienteDto) {

        Cliente cliente = cambiarAcliente(clienteDto);

        repositorio.save(cliente);

        ClienteDto clienteDto1 = cambiarAclienteDto(cliente);

        return clienteDto1;
    }

    @Override
    public void eliminaCliente(int id) {

        repositorio.deleteById(id);

    }

    @Override
    public ClienteDto editaCliente(int id, ClienteDto clienteDto) {

        Cliente cliente = repositorio.findById(id).orElseThrow( () -> new RecursoNotFounException("cliente", "id", id));

        cliente.setNombre(clienteDto.getNombre());
        cliente.setApellido(clienteDto.getApellido());
        cliente.setEmail(clienteDto.getEmail());

        repositorio.save(cliente);

        ClienteDto clienteDto1 = cambiarAclienteDto(cliente);

        return clienteDto1;
    }


    public ClienteDto cambiarAclienteDto(Cliente cliente){

        ClienteDto clienteDto = modelMapper.map(cliente, ClienteDto.class);

        return clienteDto;
    }

    public Cliente cambiarAcliente(ClienteDto clienteDto){

        Cliente cliente = modelMapper.map(clienteDto, Cliente.class);

        return cliente;
    }
}
