package com.mx.jsen.application.service;

import com.mx.jsen.application.vo.JLoginVO;

public interface LoginService {
	public JLoginVO validarUsuario(Long numero, String password);
}
