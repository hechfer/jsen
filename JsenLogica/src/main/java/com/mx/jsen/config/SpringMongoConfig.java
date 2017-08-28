package com.mx.jsen.config;

import java.util.Arrays;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

@Configuration
@ComponentScan(basePackages = "com.mx.jsen.application.dao")
@PropertySource("classpath:config/mongoDB.properties")
public class SpringMongoConfig  {
	
	//Logger
	private static final Logger logger = LogManager.getLogger(SpringMongoConfig.class);
		
	@Value("${mongodb.url}")
	private String mongodbUrl;
	
	@Value("${mongodb.puerto}")
	private String mongoPuerto;
	
	@Value("${mongodb.db}")
	private String defaultDb;
	
	@Value("${mongodb.user}")
	private String user;
	
	@Value("${mongodb.pass}")
	private String pass;
	
	@Bean
	public MongoDbFactory mongoDbFactory() throws Exception {		
		logger.info("*************** ASIGNANDO VALORES PARA DB ****************");
		MongoCredential userCredentials = MongoCredential.createScramSha1Credential(user, defaultDb, pass.toCharArray());
		ServerAddress address = new ServerAddress(mongodbUrl, Integer.valueOf(mongoPuerto));
		MongoClient mongoClient = new MongoClient(address, Arrays.asList(userCredentials));		
		return new SimpleMongoDbFactory(mongoClient, defaultDb);
	
	}
	 
	@Bean
	public MongoTemplate mongoTemplate() throws Exception {
		MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
		logger.info("*************** CREADO MONGO TEMPLATE ****************");
		return mongoTemplate;
	}	
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
