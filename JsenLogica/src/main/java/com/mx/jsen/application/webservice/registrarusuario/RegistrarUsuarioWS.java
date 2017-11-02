package com.mx.jsen.application.webservice.registrarusuario;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.mx.jsen.application.model.TblLada;

@WebService
public interface RegistrarUsuarioWS {
	public String registrarUsuario(@WebParam(name="correo") String correo, 
			@WebParam(name="numero") Long numero, 
			@WebParam(name="password") String password,
			@WebParam(name="lada") Long lada);
	
	public List<TblLada> consultarLada();
}
