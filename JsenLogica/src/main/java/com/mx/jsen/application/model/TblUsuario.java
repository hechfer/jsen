package com.mx.jsen.application.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="T_Usuario")
public class TblUsuario implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_Usuario", nullable = false, length = 11)
	private Long  idUsuario;
	@Column(name = "numero", nullable = false, length = 11)
	private Long numero;
	@Column(name = "password", nullable = false, length = 100)
	private String password;
	@Column(name = "fecha_ultima_sesion", nullable = false)
	private Date fechaUltimaSesion;
	@Column(name = "rol", nullable = false, length = 20)
	private String rol;
	@Column(name = "correo", nullable = false, length = 150)
	private String correo;
	@OneToOne
    @JoinColumn(name = "id_Lada")
	private TblLada tblLada; 
	
	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
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

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public TblLada getTblLada() {
		return tblLada;
	}

	public void setTblLada(TblLada tblLada) {
		this.tblLada = tblLada;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.correo+this.password+this.rol+this.password;
	}
	
	

}
