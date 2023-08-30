package com.doncurrulo.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.doncurrulo.app.entity.DocumentoAlmacenado;

public interface DocumentoAlmacenadoRepository extends CrudRepository<DocumentoAlmacenado, Long>
{
	@Query("SELECT da FROM DocumentoAlmacenado da WHERE da.estado = 'A' AND da.eliminado = false")
	Iterable<DocumentoAlmacenado> list();
	
	@Query("SELECT da FROM DocumentoAlmacenado da WHERE da.fileName = :fileName AND da.estado = 'A' AND da.eliminado = false")
	Optional<DocumentoAlmacenado> findByFileName(String fileName);
}