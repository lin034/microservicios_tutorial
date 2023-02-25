package com.pildoraslin.aurrera.service;

import com.pildoraslin.aurrera.dto.SugerenciaDto;

import java.util.List;

public interface SugerenciaService {


    public List<SugerenciaDto> dameSugerencias();


    public List<SugerenciaDto> sugerenciaPorClienteId(int clienteId);

    public SugerenciaDto creaSugerencia(int clienteId, SugerenciaDto sugerenciaDto);

    public SugerenciaDto editaSugerencia(int clienteId, int id, SugerenciaDto sugerenciaDto);
}
