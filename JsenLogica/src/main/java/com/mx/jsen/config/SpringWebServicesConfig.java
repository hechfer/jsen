package com.mx.jsen.config;

import javax.xml.ws.Endpoint;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.ws.config.annotation.EnableWs;

import com.mx.jsen.application.webservice.login.LoginWS;
import com.mx.jsen.application.webservice.login.LoginWSImpl;
import com.mx.jsen.application.webservice.registrarusuario.RegistrarUsuarioWS;
import com.mx.jsen.application.webservice.registrarusuario.RegistrarUsuarioWSImpl;

@EnableWs
@Configuration
@ImportResource({"classpath:META-INF/cxf/cxf.xml"})
@ComponentScan(basePackages = "com.mx.jsen.application.webservice")
public class SpringWebServicesConfig {
	
	@Bean
    public Endpoint endpoint() {
		EndpointImpl endpoint = new EndpointImpl(cxf(), loginWs());
        endpoint.publish("/loginWs");
        return endpoint;
    }
	
	@Bean
    public Endpoint endpoint1() {
		EndpointImpl endpoint = new EndpointImpl(cxf(), registrarUsuarioWs());
        endpoint.publish("/registrarUsuarioWs");
        return endpoint;
    }
	
	@Bean(destroyMethod = "shutdown")
	public SpringBus cxf() {
	    return new SpringBus();
	}
	
	@Bean
    public RegistrarUsuarioWS registrarUsuarioWs() {
        return new RegistrarUsuarioWSImpl();
    }
	
	@Bean
    public LoginWS loginWs() {
        return new LoginWSImpl();
    }

}
