package com.doncurrulo.app.controladores;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.doncurrulo.app.entity.Cliente;
import com.doncurrulo.app.service.ClienteService;
import com.doncurrulo.app.utilidades.GenericResponse;

@RestController
@RequestMapping("api/cliente")
public class ClienteController
{
	private final ClienteService service;
	
	public ClienteController(ClienteService service)
	{
		this.service = service;
	}
	
	@SuppressWarnings("rawtypes")
	@PostMapping
	public GenericResponse save(@Validated @RequestBody Cliente c)
	{
		return this.service.save(c);
	}
	
	@SuppressWarnings("rawtypes")
	@PutMapping("/{id}")
	public GenericResponse update(@PathVariable int id, @Validated @RequestBody Cliente c)
	{
		c.setId_cliente(id);
		return this.service.save(c);
	}
}