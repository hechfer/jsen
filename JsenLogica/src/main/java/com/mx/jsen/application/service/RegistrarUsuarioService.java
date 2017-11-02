package com.mx.jsen.application.service;

import java.util.List;

import com.mx.jsen.application.model.TblLada;

public interface RegistrarUsuarioService {
	public String insertarUsuario(String correo, Long numero, String passsword, Long lada);
	public List<TblLada> consultarLada();
}
