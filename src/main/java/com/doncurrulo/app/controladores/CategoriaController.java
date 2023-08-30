package com.doncurrulo.app.controladores;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doncurrulo.app.service.CategoriaService;
import com.doncurrulo.app.utilidades.GenericResponse;

@RestController
@RequestMapping("api/categoria")
public class CategoriaController
{
	private final CategoriaService service;
	
	public CategoriaController(CategoriaService service)
	{
		this.service = service;
	}
	
	@SuppressWarnings("rawtypes")
	@GetMapping
	public GenericResponse listarCategoriasActivas()
	{
		return this.service.listarCategoriasActivas();
	}
}