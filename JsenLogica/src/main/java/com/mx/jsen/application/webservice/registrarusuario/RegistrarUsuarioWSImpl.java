package com.mx.jsen.application.webservice.registrarusuario;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import com.mx.jsen.application.service.RegistrarUsuarioService;

@WebService(endpointInterface = "com.mx.jsen.application.webservice.registrarusuario.RegistrarUsuarioWS"
		, serviceName = "registrarUsuarioService")
public class RegistrarUsuarioWSImpl implements RegistrarUsuarioWS{
	
	@Autowired
	private RegistrarUsuarioService service;
	
	public String registrarUsuario(String correo, String username, String password){
		return service.insertarUsuario(correo, username, password);
	}
}
