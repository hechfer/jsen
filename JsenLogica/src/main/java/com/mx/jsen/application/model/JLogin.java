package com.mx.jsen.application.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "j_login")
public class JLogin implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long  id;
	private String username;
	private String password;
	private Date fechaUltimaSesion;
	private String rol;
	private String email;
	
	public JLogin(){
		//contructor
	}
	public JLogin(Long id, String username, String password, 
			Date fechaUltimaSesion, String rol){
		this.id = id;
		this.username = username;
		this.password = password;
		this.fechaUltimaSesion = fechaUltimaSesion;		
		this.rol = rol;
	}
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
	
}
