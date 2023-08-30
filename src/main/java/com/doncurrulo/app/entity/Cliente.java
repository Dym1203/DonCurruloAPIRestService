package com.doncurrulo.app.entity;

import javax.persistence.*;

@Entity
public class Cliente
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_cliente;
	
	@Column(length = 50)
	private String nombres;
	
	@Column(length = 50)
	private String apellidos;
	
	@Column(length = 30)
	private String tipoDocumento;
	
	@Column(length = 20)
	private String numDocumento;
	
	@Column(length = 80)
	private String direccionEnvio;
	
	@Column(length = 30)
	private String distrito;
	
	@Column(length = 10)
	private String telefono;
	
	@Column(length = 50)
	private String correoElectronico;
	
	@OneToOne
	private DocumentoAlmacenado	foto;

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getNumDocumento() {
		return numDocumento;
	}

	public void setNumDocumento(String numDocumento) {
		this.numDocumento = numDocumento;
	}

	public String getDireccionEnvio() {
		return direccionEnvio;
	}

	public void setDireccionEnvio(String direccionEnvio) {
		this.direccionEnvio = direccionEnvio;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public DocumentoAlmacenado getFoto() {
		return foto;
	}

	public void setFoto(DocumentoAlmacenado foto) {
		this.foto = foto;
	}
	
	public String getNombreCompletoCliente() {
		return this.nombres != null && this.apellidos != null ? this.nombres + " " + this.apellidos: "-----";
	}
}