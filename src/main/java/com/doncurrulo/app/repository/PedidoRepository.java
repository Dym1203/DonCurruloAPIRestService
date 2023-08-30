package com.doncurrulo.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.doncurrulo.app.entity.Pedido;

public interface PedidoRepository extends CrudRepository<Pedido, Integer>
{
	@Query("SELECT P FROM Pedido P WHERE P.cliente.id_cliente=:idCli")
	Iterable<Pedido> devolverMisCompras(int idCli);
	
	@Query("SELECT P FROM Pedido P WHERE P.id_pedido=:idOrden AND P.cliente.id_cliente=:idCli")
	Optional<Pedido> findByIdAndClienteId(int idCli, int idOrden);
}