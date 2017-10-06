package com.mx.jsen.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan({ "com.mx.jsen.application.service", "com.mx.jsen.application.encryption" })
@Import({SpringDataBaseConfig.class, SpringWebServicesConfig.class})
public class SpringRootConfig {
	
}
