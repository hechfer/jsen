package com.mx.jsen.application.dao;

import com.mx.jsen.application.model.JLogin;

public interface RegistrarUsuarioDao {
	public void insertarUsuario(JLogin login);
	public boolean existeEmail(String correo);
	public boolean existeUsuario(String username);
}
