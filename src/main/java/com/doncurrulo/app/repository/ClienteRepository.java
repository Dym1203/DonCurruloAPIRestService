package com.doncurrulo.app.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.doncurrulo.app.entity.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Integer>
{
	@Query(value = "(SELECT EXISTS(SELECT id_cliente FROM cliente WHERE num_documento=:dni))", nativeQuery = true)
	int existByDoc(String dni);
	
	@Query(value = "SELECT EXISTS(SELECT C.* FROM cliente C WHERE C.num_documento=:dni AND NOT (C.id_cliente=:id))", nativeQuery = true)
	int existByDocForUpdate(String dni, int id);
}