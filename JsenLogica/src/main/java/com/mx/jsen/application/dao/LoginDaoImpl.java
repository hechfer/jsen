package com.mx.jsen.application.dao;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.mx.jsen.application.model.JLogin;

@Repository
public class LoginDaoImpl extends AbstractDao implements LoginDao {
	
	// Logger
	private static final Logger logger = LogManager.getLogger(LoginDaoImpl.class);

	public JLogin validarUsuario(String username, String password) {
		JLogin login = null;
		try {
			Criteria criteria = getSession().createCriteria(JLogin.class);
			criteria.add(Restrictions.eq("username",username)).add(Restrictions.eq("password", password));
			login = (JLogin) criteria.uniqueResult();
		} catch (Exception e) {
			logger.error(e.getCause() + "\n" + e.getMessage());
		}
		return login;
	}
}
