package com.mx.jsen.application.dao;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.mx.jsen.application.model.JLogin;

@Repository
public class RegistrarUsuarioDaoImpl extends AbstractDao implements RegistrarUsuarioDao {
	private static final Logger logger = LogManager.getLogger(RegistrarUsuarioDaoImpl.class);
	
	public void insertarUsuario(JLogin login) {
		persist(login);
	}

	public boolean existeEmail(String correo) {
		JLogin login = null;
		try {
			Criteria criteria = getSession().createCriteria(JLogin.class);
			criteria.add(Restrictions.eq("email",correo));
			login = (JLogin) criteria.uniqueResult();
		} catch (Exception e) {
			logger.error(e.getCause() + "\n" + e.getMessage());
		}
		return login != null ? true : false;
	}

	public boolean existeUsuario(String username) {
		JLogin login = null;
		try {
			Criteria criteria = getSession().createCriteria(JLogin.class);
			criteria.add(Restrictions.eq("username",username));
			login = (JLogin) criteria.uniqueResult();
		} catch (Exception e) {
			logger.error(e.getCause() + "\n" + e.getMessage());
		}
		return login != null ? true : false;
	}
}
