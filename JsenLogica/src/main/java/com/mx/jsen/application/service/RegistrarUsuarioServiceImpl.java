package com.mx.jsen.application.service;

import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.jsen.application.dao.RegistrarUsuarioDao;
import com.mx.jsen.application.dao.SequenceIdDao;
import com.mx.jsen.application.model.JLogin;
import com.mx.jsen.application.util.Constantes;

@Service
public class RegistrarUsuarioServiceImpl implements RegistrarUsuarioService{
	private static final Logger logger = LogManager.getLogger(RegistrarUsuarioServiceImpl.class);
	
	@Autowired
	private RegistrarUsuarioDao registrarUsuarioDao;
	
	@Autowired
	private SequenceIdDao sequenceDao;
	
	public String insertarUsuario(String correo, String username, String password){
		String mensaje = null;
		mensaje = this.validarCorreoUsuarioPass(correo, username, password);
		
		if(mensaje == null){
			try {
				JLogin loginPersistence = new JLogin();
				loginPersistence.setId(sequenceDao.getNextSequenceId("login"));
				loginPersistence.setEmail(correo);
				loginPersistence.setPassword(password);
				loginPersistence.setUsername(username);
				loginPersistence.setFechaUltimaSesion(new Date());
				loginPersistence.setRol(Constantes.ROL_USUARIO);
				
				registrarUsuarioDao.insertarUsuario(loginPersistence);
			} catch (Exception e) {
				mensaje = "ERROR al generar o guardar los datos";
				logger.info("ERRO JSEN : "+e.getMessage());
			}
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
				if(registrarUsuarioDao.existeEmail(correo)){
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
				if(registrarUsuarioDao.existeUsuario(username)){
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
