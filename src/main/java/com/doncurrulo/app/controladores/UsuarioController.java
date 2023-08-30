package com.doncurrulo.app.controladores;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doncurrulo.app.entity.Usuario;
import com.doncurrulo.app.service.UsuarioService;
import com.doncurrulo.app.utilidades.GenericResponse;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("api/usuario")
public class UsuarioController
{
	private final UsuarioService service;
	
	public UsuarioController(UsuarioService service)
	{
		this.service = service;
	}
	
	@PostMapping("/login")
	public GenericResponse<Usuario> login(HttpServletRequest request)
	{
		String email = request.getParameter("email");
		String contrasenia = request.getParameter("pass");
		return this.service.login(email, contrasenia);
	}
	
	@SuppressWarnings("rawtypes")
	@PostMapping
	public GenericResponse save(@RequestBody Usuario u)
	{
		return this.service.guardarUsuario(u);
	}
	
	@SuppressWarnings("rawtypes")
	@PutMapping("/{id}")
	public GenericResponse update(@PathVariable int id, @RequestBody Usuario u)
	{
		return this.service.guardarUsuario(u);
	}
}