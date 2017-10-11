package com.mx.jsen.application.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="j_login")
public class TblJLogin implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_login", nullable = true)
	private Long  idLogin;
	@Column(name = "username", nullable = false)
	private String username;
	@Column(name = "password", nullable = false)
	private String password;
	@Column(name = "fecha_ultima_sesion", nullable = false)
	private Date fechaUltimaSesion;
	@Column(name = "rol", nullable = false)
	private String rol;
	@Column(name = "email", nullable = false)
	private String email;
	
	public Long getIdLogin() {
		return idLogin;
	}
	public void setIdLogin(Long idLogin) {
		this.idLogin = idLogin;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
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
