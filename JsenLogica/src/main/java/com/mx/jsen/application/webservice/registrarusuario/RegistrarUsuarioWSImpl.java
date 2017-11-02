package com.mx.jsen.application.webservice.registrarusuario;

import java.util.List;

import javax.jws.WebService;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.mx.jsen.application.model.TblLada;
import com.mx.jsen.application.service.RegistrarUsuarioService;

@WebService(endpointInterface = "com.mx.jsen.application.webservice.registrarusuario.RegistrarUsuarioWS"
		, serviceName = "registrarUsuarioService")
public class RegistrarUsuarioWSImpl implements RegistrarUsuarioWS{
	private static final Logger logger = LogManager.getLogger(RegistrarUsuarioWSImpl.class);
	
	@Autowired
	private RegistrarUsuarioService service;
	
	public String registrarUsuario(String correo, Long numero, String password, Long lada){
		String mensaje = null;
		try{
			mensaje = service.insertarUsuario(correo, numero, password, lada);
		}
		 catch (Exception e) {
			 logger.error("chec012");			
			 mensaje = "ERROR al generar o guardar los datos";
			 logger.info("ERRO JSEN : "+e.getMessage());			
		 }
		return mensaje;
	}
	
	public List<TblLada> consultarLada(){
		return service.consultarLada();
	}
}
