package com.mx.jsen.application.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.mx.jsen.application.model.TblJLogin;
@Repository
public interface LoginRepository extends JpaRepository<TblJLogin, Integer>{

	@Query("SELECT tblJLogin FROM TblJLogin tblJLogin WHERE tblJLogin.username =:username AND tblJLogin.password =:password")
	public TblJLogin validarUsuario(@Param("username")String username, @Param("password")String password);
	
	@Query("SELECT count(tblJLogin)>0 from TblJLogin tblJLogin WHERE tblJLogin.username =:username ")
	public boolean existeUsuario(@Param("username")String username);
	
	@Query("SELECT count(tblJLogin)>0 from TblJLogin tblJLogin WHERE tblJLogin.email =:email ")
	public boolean existeEmail(@Param("email")String email);
	
}
