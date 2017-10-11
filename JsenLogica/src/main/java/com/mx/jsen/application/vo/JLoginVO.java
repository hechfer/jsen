package com.mx.jsen.application.vo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

public class JLoginVO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long  id;
	private String username;
	private String password;
	private Date fechaUltimaSesion;
	private String rol;
	private String email;
	
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.email+this.password+this.rol+this.username+this.password;
	}
	
}
