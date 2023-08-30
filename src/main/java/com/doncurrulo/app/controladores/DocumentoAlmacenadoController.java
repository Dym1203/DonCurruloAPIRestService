package com.doncurrulo.app.controladores;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.doncurrulo.app.entity.DocumentoAlmacenado;
import com.doncurrulo.app.service.DocumentoAlmacenadoService;
import com.doncurrulo.app.utilidades.GenericResponse;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("api/documento-almacenado")
public class DocumentoAlmacenadoController {
	private DocumentoAlmacenadoService service;
	
	public DocumentoAlmacenadoController(DocumentoAlmacenadoService service)
	{
		this.service = service;
	}
	
	@SuppressWarnings("rawtypes")
	@GetMapping
	public GenericResponse list()
	{
		return service.list();
	}
	
	@SuppressWarnings("rawtypes")
	@GetMapping("/{id}")
	public GenericResponse find(@PathVariable Long id)
	{
		return null;
	}
	
	@GetMapping("/download/{fileName}")
	public ResponseEntity<Resource> download(@PathVariable String fileName, HttpServletRequest request)
	{
		return service.downloadByFileName(fileName, request);
	}
	
	@SuppressWarnings("rawtypes")
	@PostMapping
	public GenericResponse save(@ModelAttribute DocumentoAlmacenado obj)
	{
		return service.save(obj);
	}
	
	@SuppressWarnings("rawtypes")
	public GenericResponse update(Long aLong, DocumentoAlmacenado obj)
	{
		return null;
	}
	
	@SuppressWarnings("rawtypes")
	public GenericResponse delete(Long aLong)
	{
		return null;
	}
}