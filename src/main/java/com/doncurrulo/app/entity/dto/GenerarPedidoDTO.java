package com.doncurrulo.app.entity.dto;

import com.doncurrulo.app.entity.Cliente;
import com.doncurrulo.app.entity.DetallePedido;
import com.doncurrulo.app.entity.Pedido;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GenerarPedidoDTO
{
	private Pedido pedido;
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Iterable<DetallePedido> detallePedido;
	private Cliente cliente;
	
	public GenerarPedidoDTO()
	{
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Iterable<DetallePedido> getDetallePedido() {
		return detallePedido;
	}

	public void setDetallePedido(Iterable<DetallePedido> detallePedido) {
		this.detallePedido = detallePedido;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}