package com.mx.jsen.application.webservice.login;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import com.mx.jsen.application.service.LoginService;
import com.mx.jsen.application.vo.JLoginVO;

@WebService(endpointInterface = "com.mx.jsen.application.webservice.login.LoginWS"
	, serviceName = "loginService")
public class LoginWSImpl implements LoginWS{
	
	@Autowired
	private LoginService service;
	
	public JLoginVO login(Long numero, String password){		
		return service.validarUsuario(numero, password);
	}
}
