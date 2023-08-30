package com.doncurrulo.app.service;

import org.springframework.stereotype.Service;

import com.doncurrulo.app.entity.Usuario;
import com.doncurrulo.app.repository.UsuarioRepository;
import com.doncurrulo.app.utilidades.GenericResponse;

import javax.transaction.Transactional;
import java.util.Optional;

import static com.doncurrulo.app.utilidades.Global.*;

@Service
@Transactional
public class UsuarioService
{
	private final UsuarioRepository repository;
	
	public UsuarioService(UsuarioRepository repository)
	{
		this.repository = repository;
	}
	
	//Método para iniciar sesión
	public GenericResponse<Usuario> login(String email, String contrasenia)
	{
		Optional<Usuario> optU = this.repository.login(email, contrasenia);
		if (optU.isPresent())
		{
			return new GenericResponse<Usuario>(TIPO_AUTH, RPTA_OK, "¡Has iniciado sesión correctamente!", optU.get());
		}
		else
		{
			return new GenericResponse<Usuario>(TIPO_AUTH, RPTA_WARNING, "Lo sentimos, ese usuario no existe", new Usuario());
		}
	}
	
	//Método para guardar credenciales del usuario
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public GenericResponse guardarUsuario(Usuario u)
	{
		Optional<Usuario> optU = this.repository.findById(u.getId_usuario());
		int idf = optU.isPresent() ? optU.get().getId_usuario() : 0;
		if (idf == 0)
		{
			return new GenericResponse(TIPO_DATA, RPTA_OK, "¡Usuario registrado correctamente!", this.repository.save(u));
		}
		else
		{
			return new GenericResponse(TIPO_DATA, RPTA_OK, "¡Datos del usuario actualizados!", this.repository.save(u));
		}
	}
}