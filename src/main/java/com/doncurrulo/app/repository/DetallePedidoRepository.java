package com.doncurrulo.app.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.doncurrulo.app.entity.DetallePedido;

public interface DetallePedidoRepository extends CrudRepository<DetallePedido, Integer>
{
	@Query("SELECT DP FROM DetallePedido DP WHERE DP.pedido.id_pedido=:idP")
	Iterable<DetallePedido> findByPedido(int idP);
	
	@Query(value = "SELECT SUM(dp.cantidad * dp.precio) AS \"Total\" FROM detalle_pedido dp JOIN pedido p\n"
			+ "ON p.id_pedido = dp.pedido_id_pedido\n"
			+ "WHERE p.cliente_id_cliente =:idCli AND p.id_pedido =:idPed", nativeQuery = true)
	Double totalByIdCustomer(int idCli, int idPed);
}