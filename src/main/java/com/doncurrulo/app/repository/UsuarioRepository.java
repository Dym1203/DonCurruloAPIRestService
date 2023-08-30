package com.doncurrulo.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.doncurrulo.app.entity.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer>
{
	@Query("SELECT U FROM Usuario U WHERE U.email=:correo AND U.clave=:password")
	Optional<Usuario> login(String correo, String password);
}