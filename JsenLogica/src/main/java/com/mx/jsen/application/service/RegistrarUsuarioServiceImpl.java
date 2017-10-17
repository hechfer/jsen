package com.mx.jsen.application.service;

import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.mx.jsen.application.dao.LoginRepository;
import com.mx.jsen.application.model.TblJLogin;
import com.mx.jsen.application.util.Constantes;


@Service

public class RegistrarUsuarioServiceImpl implements RegistrarUsuarioService{
	private static final Logger logger = LogManager.getLogger(RegistrarUsuarioServiceImpl.class);
	
	@Autowired
	private LoginRepository loginRepository;
	
	@Transactional(rollbackFor = Exception.class)
	public String insertarUsuario(String correo, String username, String password){
		String mensaje = null;
		mensaje = this.validarCorreoUsuarioPass(correo, username, password);
		logger.info("El valor del mensaje es "+mensaje);
		if(null == mensaje ){
				
				TblJLogin loginPersistence = new TblJLogin();
				loginPersistence.setEmail(correo);
				loginPersistence.setPassword(password);
				loginPersistence.setUsername(username);
				loginPersistence.setFechaUltimaSesion(new Date());
				loginPersistence.setRol(Constantes.ROL_USUARIO);
				logger.info("Va a guardad en la base de datos8");
				 
				loginRepository.save(loginPersistence);	
		}
		return mensaje;
	}
	
	
	
	private String validarCorreoUsuarioPass(String correo, String username, String password){
		String mensaje = "";
		if(StringUtils.isBlank(correo)){
			mensaje += "El email no puede estar vacio. ";
		}else{
			//validar correo no exista
			try {
				logger.info("va por spring data existsByEmail");
				if(loginRepository.existeEmail(correo)){
					mensaje += "El email ya esta registrado con otro usuario. ";
				}
			} catch (Exception e) {
				logger.info("ERROR JSEN VALIDAR CORREO: "+e.getMessage());
			}
		}
		
		if(StringUtils.isBlank(username)){			
			mensaje += "El usuario no puede estar vacio. ";
		}else{
			//validar usuario no exista
			try {
				logger.info("va por spring data existsByUsername");
				if(loginRepository.existeUsuario(username)){
					mensaje += "El usuario ya existe. ";
				}
			} catch (Exception e) {
				logger.info("ERROR JSEN VALIDAR USUARIO: "+e.getMessage());
			}
		}
		
		if(StringUtils.isBlank(password)){			
			mensaje += "La contraseña no puede estar vacio. ";
		}
		
		return StringUtils.isBlank(mensaje) ? null : mensaje;
	}
	
}
