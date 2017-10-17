package com.mx.jsen.config;

import java.util.Properties;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = "com.mx.jsen.application.dao",
entityManagerFactoryRef ="entityManagerFactory"
,
transactionManagerRef = "transactionManager"
)
@EnableTransactionManagement
@EnableSpringDataWebSupport

@PropertySource("classpath:config/mysqlDB.properties")
public class SpringDataBaseConfig {

	@Value("${hibernate.show.sql}")
	private String hibernateShowSql;

	@Value("${hibernate.dialect}")
	private String hibernateDialect;

	@Value("${jndi.jsen}")
	private String jndiJsen;
	
	 
	/**
	 * Enetity Managaer Factory
	 * @return
	 */
	@Bean(name = "entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean  entityManagerFactory() {
		Properties properties = new Properties();
	    properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
	    	 
	    	 
	    LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(this.getDataSource());
        emf.setPersistenceUnitName("default");
        emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        emf.setPackagesToScan("com.mx.jsen.application.model");
	    return emf;
	    }

	
	/**
	 * TransactionManager
	 * @return
	 */
	
	@Bean(name="transactionManager")
	   public PlatformTransactionManager transactionManager(){
	      JpaTransactionManager transactionManager
	        = new JpaTransactionManager();
	      transactionManager.setEntityManagerFactory(
	    		  entityManagerFactory().getObject() );
	      
	      transactionManager.setDataSource(this.getDataSource());
	      
	      return transactionManager;
	   }
	   
	 
	/**
	 * Datasource 	 
	 * @return
	 */
	@Bean
	public DataSource getDataSource() {
		final JndiDataSourceLookup dsLookup = new JndiDataSourceLookup();
		dsLookup.setResourceRef(true);
		DataSource dataSource = dsLookup.getDataSource(jndiJsen);
		return dataSource;
	}
		    
	/**
	 * PropertySourcesPlaceholderConfigurer
	 * 
	 * @return
	 */
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	/**
	 * passwordEncoder
	 * 
	 * @return
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
