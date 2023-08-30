package com.doncurrulo.app.entity;

import javax.persistence.*;

@Entity
public class Categoria
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_categoria;
	
	@Column(length = 30)
	private String nombre;
	
	@Column
	private boolean vigencia;
	
	@OneToOne
	private DocumentoAlmacenado foto;

	public int getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(int id_categoria) {
		this.id_categoria = id_categoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isVigencia() {
		return vigencia;
	}

	public void setVigencia(boolean vigencia) {
		this.vigencia = vigencia;
	}

	public DocumentoAlmacenado getFoto() {
		return foto;
	}

	public void setFoto(DocumentoAlmacenado foto) {
		this.foto = foto;
	}
}