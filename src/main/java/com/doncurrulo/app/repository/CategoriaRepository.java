package com.doncurrulo.app.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.doncurrulo.app.entity.Categoria;

public interface CategoriaRepository extends CrudRepository<Categoria, Integer>
{	
	@Query("SELECT C FROM Categoria C WHERE C.vigencia IS 1")
	Iterable<Categoria> listarCategoriasActivas();
}