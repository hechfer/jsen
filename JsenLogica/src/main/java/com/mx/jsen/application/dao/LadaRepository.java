package com.mx.jsen.application.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mx.jsen.application.model.TblLada;

public interface LadaRepository extends JpaRepository<TblLada, Integer>{
	@Query("SELECT tblLada FROM TblLada tblLada WHERE tblLada.claveLocalidad =:claveLocalidad")
	public TblLada consultarLadaPorClave(@Param("claveLocalidad")Long claveLocalidad);
}
