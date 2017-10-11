package com.mx.jsen.application.service;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.mx.jsen.application.dao.LoginRepository;
import com.mx.jsen.application.model.TblJLogin;
import com.mx.jsen.application.vo.JLoginVO;

@Service
@Transactional
public class LoginServiceImpl implements LoginService{
	private static final Logger logger = LogManager.getLogger(LoginServiceImpl.class);
	

	@Autowired
	private LoginRepository loginRepository;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	public JLoginVO validarUsuario(String username, String password){		
		logger.info(":: Va por spring data ::");
		TblJLogin login = loginRepository.validarUsuario(username, password);
		JLoginVO vo = null;
		if(login != null){
			 vo  = modelMapper.map(login, JLoginVO.class);
		}
		
		return vo;
	}
}
