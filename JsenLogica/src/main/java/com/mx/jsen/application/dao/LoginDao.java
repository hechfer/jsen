package com.mx.jsen.application.dao;

import com.mx.jsen.application.model.JLogin;

public interface LoginDao {
	public JLogin validarUsuario(String usuario, String password);
}
