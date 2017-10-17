package com.mx.jsen.application.webservice.registrarusuario;

import javax.jws.WebService;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.mx.jsen.application.service.RegistrarUsuarioService;
import com.mx.jsen.application.service.RegistrarUsuarioServiceImpl;

@WebService(endpointInterface = "com.mx.jsen.application.webservice.registrarusuario.RegistrarUsuarioWS"
		, serviceName = "registrarUsuarioService")
public class RegistrarUsuarioWSImpl implements RegistrarUsuarioWS{
	
	private static final Logger logger = LogManager.getLogger(RegistrarUsuarioServiceImpl.class);
	
	
	@Autowired
	private RegistrarUsuarioService service;
	
	public String registrarUsuario(String correo, String username, String password){
		String mensaje = null;
		
		try{
			mensaje = service.insertarUsuario(correo, username, password);
		}
		 catch (Exception e) {
		 logger.error("chec012");			
		 mensaje = "ERROR al generar o guardar los datos";
		 logger.info("ERRO JSEN : "+e.getMessage());				
		 }
		
		return mensaje;
	}
}
