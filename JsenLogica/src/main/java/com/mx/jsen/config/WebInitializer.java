package com.mx.jsen.config;

import java.util.TimeZone;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.apache.cxf.transport.servlet.CXFServlet;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInitializer extends
		AbstractAnnotationConfigDispatcherServletInitializer {
	//Logger
	private static final Logger logger = LogManager.getLogger(WebInitializer.class);
	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		//Configura Zona horaria UTC.
		//TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
		logger.info("*************** INICIA LOGICA ESCANEO ANOTACIONES SERVICE ****************");
		return new Class[] { SpringRootConfig.class };
	}


	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}
	
	 @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);
        registerJAXWSServlet(servletContext);
    }

	
	private void registerJAXWSServlet(ServletContext servletContext) {
		logger.info("*************** INICIA SERVLET CXF ****************");
        ServletRegistration.Dynamic dispatcher = 
        		servletContext.addServlet("cxf-service", new CXFServlet());
        dispatcher.addMapping("/ws/*");

    }

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

}
