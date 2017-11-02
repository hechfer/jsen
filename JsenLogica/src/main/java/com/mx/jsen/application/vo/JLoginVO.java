package com.mx.jsen.application.vo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

public class JLoginVO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long  id;
	private Long numero;
	private String password;
	private Date fechaUltimaSesion;
	private String rol;
	private String correo;
	private Long lada;
	
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getNumero() {
		return numero;
	}
	public void setNumero(Long numero) {
		this.numero = numero;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getFechaUltimaSesion() {
		return fechaUltimaSesion;
	}
	public void setFechaUltimaSesion(Date fechaUltimaSesion) {
		this.fechaUltimaSesion = fechaUltimaSesion;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	
	public Long getLada() {
		return lada;
	}
	public void setLada(Long lada) {
		this.lada = lada;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.correo+this.password+this.rol+this.numero+this.password+this.lada;
	}
	
}
