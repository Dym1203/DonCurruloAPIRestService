package com.doncurrulo.app.service;

import org.springframework.stereotype.Service;

import com.doncurrulo.app.repository.PlatoRepository;
import com.doncurrulo.app.utilidades.GenericResponse;

import javax.transaction.Transactional;

import static com.doncurrulo.app.utilidades.Global.*;

@Service
@Transactional
public class PlatoService
{
	private final PlatoRepository repository;
	
	public PlatoService(PlatoRepository repository)
	{
		this.repository = repository;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public GenericResponse listarPlatosRecomendados()
	{
		return new GenericResponse(TIPO_DATA, RPTA_OK, OPERACION_CORRECTA, this.repository.listarPlatosRecomendados());
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public GenericResponse listarPlatosPorCategoria(int idC)
	{
		return new GenericResponse(TIPO_DATA, RPTA_OK, OPERACION_CORRECTA, this.repository.listarPlatosporCategoria(idC));
	}
}