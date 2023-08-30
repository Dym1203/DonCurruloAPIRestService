package com.doncurrulo.app.service;

import org.springframework.stereotype.Service;

import com.doncurrulo.app.repository.CategoriaRepository;
import com.doncurrulo.app.utilidades.GenericResponse;

import javax.transaction.Transactional;

import static com.doncurrulo.app.utilidades.Global.*;

@Service
@Transactional
public class CategoriaService
{
	private final CategoriaRepository repository;
	
	public CategoriaService(CategoriaRepository repository)
	{
		this.repository = repository;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public GenericResponse<?> listarCategoriasActivas()
	{
		return new GenericResponse(TIPO_DATA, RPTA_OK, OPERACION_CORRECTA, this.repository.listarCategoriasActivas());
	}
}