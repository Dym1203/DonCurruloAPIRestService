package com.doncurrulo.app.entity;

import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Pedido
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_pedido;
	
	@Column
	@JsonFormat(pattern = "dd-MM-yyyy", timezone = "America/Lima")
	private Date fecha;
	
	@OneToOne
	private Cliente cliente;
	
	@Column
	private Double total;
	
	@Column
	private boolean anularPedido;

	public int getId_pedido() {
		return id_pedido;
	}

	public void setId_pedido(int id_pedido) {
		this.id_pedido = id_pedido;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public boolean isAnularPedido() {
		return anularPedido;
	}

	public void setAnularPedido(boolean anularPedido) {
		this.anularPedido = anularPedido;
	}
}