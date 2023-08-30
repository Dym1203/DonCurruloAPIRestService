package com.doncurrulo.app.entity;

import javax.persistence.*;

@Entity
public class DetallePedido
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_detalle;
	
	@Column
	private int cantidad;
	
	@Column
	private Double precio;
	
	@OneToOne
	private Plato plato;
	
	@OneToOne
	private Pedido pedido;

	public int getId_detalle() {
		return id_detalle;
	}

	public void setId_detalle(int id_detalle) {
		this.id_detalle = id_detalle;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Plato getPlato() {
		return plato;
	}

	public void setPlato(Plato plato) {
		this.plato = plato;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	public String getNombre() {
		return this.plato!= null ? this.plato.getNombre() : "----";
	}
	
	public Double getSubTotal() {
		return this.cantidad * this.precio;
	}
	
	public Double getTotal() {
		return (this.cantidad * this.precio);
	}
}