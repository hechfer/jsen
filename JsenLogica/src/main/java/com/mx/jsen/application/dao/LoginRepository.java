package com.mx.jsen.application.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mx.jsen.application.model.TblUsuario;
@Repository
public interface LoginRepository extends JpaRepository<TblUsuario, Integer>{

	@Query("SELECT tblUsuario FROM TblUsuario tblUsuario WHERE tblUsuario.numero =:numero AND tblUsuario.password =:password")
	public TblUsuario validarUsuario(@Param("numero")Long numero, @Param("password")String password);
	
	@Query("SELECT count(tblUsuario)>0 from TblUsuario tblUsuario WHERE tblUsuario.numero =:numero ")
	public boolean existeUsuario(@Param("numero")Long numero);
	
	@Query("SELECT count(tblUsuario)>0 from TblUsuario tblUsuario WHERE tblUsuario.correo =:correo ")
	public boolean existeEmail(@Param("correo")String correo);
	
}
