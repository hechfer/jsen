package com.mx.jsen.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.jsen.application.dao.LoginDao;
import com.mx.jsen.application.model.JLogin;
import com.mx.jsen.application.vo.JLoginVO;

@Service
@Transactional
public class LoginServiceImpl implements LoginService{
	@Autowired
	private LoginDao loginDao;
	
	public JLoginVO validarUsuario(String username, String password){		
		JLogin login = loginDao.validarUsuario(username, password);
		JLoginVO vo = null;
		if(login != null){
			vo = new JLoginVO();
			vo.setFechaUltimaSesion(login.getFechaUltimaSesion());
			vo.setUsername(login.getUsername());
			vo.setRol(login.getRol());
			vo.setEmail(login.getEmail());
			vo.setId(login.getIdLogin());
		}
		return vo;
	}
}
