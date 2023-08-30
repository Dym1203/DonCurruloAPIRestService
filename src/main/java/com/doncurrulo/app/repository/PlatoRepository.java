package com.doncurrulo.app.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.doncurrulo.app.entity.Plato;

public interface PlatoRepository extends CrudRepository<Plato, Integer>
{
	@Query("SELECT P FROM Plato P WHERE P.recomendado IS 1")
	Iterable<Plato> listarPlatosRecomendados();
	
	@Query("SELECT P FROM Plato P WHERE P.categoria.id_categoria=:idC")
	Iterable<Plato> listarPlatosporCategoria(int idC);
	
	@Modifying
	@Query("UPDATE Plato P SET P.stock=stock-:cant WHERE P.id_plato=:id")
	void descontarStock(int cant, int id);
	
	@Modifying
	@Query("UPDATE Plato P SET P.stock=stock+:cant WHERE P.id_plato=:id")
	void aumentarStock(int cant, int id);
}