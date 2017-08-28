package com.mx.jsen.application.util;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class ConvertirFecha {
	//Logger
	private static final Logger logger = LogManager.getLogger(ConvertirFecha.class);
	public static Date localDataTimeToDate(LocalDateTime fecha){
		Date fechaFinal = null;
		try{
			fechaFinal = Date.from(fecha.toInstant(ZoneOffset.UTC));
		}catch(Exception e){
			logger.error("ERROR AL CONVERTIR FECHA: "+e.getMessage()+" : "+e.getCause());
		}
		return fechaFinal;
	}
}
