package com.mx.jsen.application.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_Lada")
public class TblLada implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_Lada", nullable = true)
	private Long  idLada;
	@Column(name = "pais", nullable = false)
	private String pais;
	@Column(name = "localidad", nullable = false)
	private String localidad;
	@Column(name = "clave_localidad", nullable = false)
	private Long claveLocalidad;
	public Long getIdLada() {
		return idLada;
	}
	public void setIdLada(Long idLada) {
		this.idLada = idLada;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public Long getClaveLocalidad() {
		return claveLocalidad;
	}
	public void setClaveLocalidad(Long claveLocalidad) {
		this.claveLocalidad = claveLocalidad;
	}
}
