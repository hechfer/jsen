package com.mx.jsen.application.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.jsen.application.dao.LadaRepository;
import com.mx.jsen.application.dao.LoginRepository;
import com.mx.jsen.application.model.TblLada;
import com.mx.jsen.application.model.TblUsuario;
import com.mx.jsen.application.util.Constantes;


@Service
public class RegistrarUsuarioServiceImpl implements RegistrarUsuarioService{
	private static final Logger logger = LogManager.getLogger(RegistrarUsuarioServiceImpl.class);
	
	@Autowired
	private LoginRepository loginRepository;
	
	@Autowired
	private LadaRepository ladaRepository;

	@Transactional(rollbackFor = Exception.class)
	public String insertarUsuario(String correo, Long numero, String password, Long lada){
		String mensaje = null;
		mensaje = this.validarCorreoUsuarioPass(correo, numero, password);
		TblLada tblLada = this.consultarLadaPorClave(lada);
		logger.info("El valor del mensaje es "+mensaje);
		if(null == mensaje ){
			
				TblUsuario loginPersistence = new TblUsuario();
				loginPersistence.setCorreo(correo);
				loginPersistence.setPassword(password);
				loginPersistence.setNumero(numero);
				loginPersistence.setFechaUltimaSesion(new Date());
				loginPersistence.setRol(Constantes.ROL_USUARIO);
				loginPersistence.setTblLada(tblLada);
				logger.info("Va a guardad en la base de datos8");

				loginRepository.save(loginPersistence);
		}
		return mensaje;
	}
	
	private TblLada consultarLadaPorClave(Long claveLocalidad){
		return ladaRepository.consultarLadaPorClave(claveLocalidad);
	}
	
	private String validarCorreoUsuarioPass(String correo, Long numero, String password){
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
		logger.info("numero cel : "+numero);
		logger.info("numero cel instancia : "+(numero instanceof Long));
		if(numero == null){
			mensaje += "El numero de celular no puede estar vacio. ";
		}else{
			//validar usuario no exista
			try {
				logger.info("va por spring data existsByUsername");
				if(loginRepository.existeUsuario(numero)){
					mensaje += "El numero de celular ya existe. ";
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

	public List<TblLada> consultarLada() {
		return ladaRepository.findAll();
	}
	
}
