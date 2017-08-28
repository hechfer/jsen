package com.mx.jsen.application.webservice.login;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.mx.jsen.application.vo.JLoginVO;

@WebService
public interface LoginWS {
	public JLoginVO login(@WebParam(name="username") String username, 
			@WebParam(name="password") String password);
}
