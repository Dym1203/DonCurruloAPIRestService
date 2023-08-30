package com.doncurrulo.app.controladores;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doncurrulo.app.service.PlatoService;
import com.doncurrulo.app.utilidades.GenericResponse;

@RestController
@RequestMapping("api/plato")
public class PlatoController
{
	private final PlatoService service;
	
	public PlatoController(PlatoService service)
	{
		this.service = service;
	}
	
	@SuppressWarnings("rawtypes")
	@GetMapping
	public GenericResponse listarPlatosRecomendados()
	{
		return this.service.listarPlatosRecomendados();
	}
	
	@SuppressWarnings("rawtypes")
	@GetMapping("/{idC}")
	public GenericResponse listarPlatosPorCategoria(@PathVariable int idC)
	{
		return this.service.listarPlatosPorCategoria(idC);
	}
}