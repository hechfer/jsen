package com.mx.jsen.application.webservice.registrarusuario;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface RegistrarUsuarioWS {
	public String registrarUsuario(@WebParam(name="correo") String correo, 
			@WebParam(name="username") String username, 
			@WebParam(name="password") String password);
}
