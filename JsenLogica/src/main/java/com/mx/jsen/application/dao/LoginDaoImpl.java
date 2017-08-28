package com.mx.jsen.application.dao;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.mx.jsen.application.model.JLogin;
import com.mx.jsen.application.util.ConstantesTablas;

@Repository
public class LoginDaoImpl implements LoginDao {
	
	// Logger
	private static final Logger logger = LogManager.getLogger(LoginDaoImpl.class);

	@Autowired
	private MongoTemplate template;

	public JLogin validarUsuario(String username, String password) {
		JLogin login = null;
		try {
			Query searchQuery = new Query(Criteria.where("username")
					.is(username).and("password").is(password));
			login = template.findOne(searchQuery, JLogin.class, ConstantesTablas.TABLA_J_LOGIN);
		} catch (Exception e) {
			logger.error(e.getCause() + "\n" + e.getMessage());
		}
		return login;
	}
}
