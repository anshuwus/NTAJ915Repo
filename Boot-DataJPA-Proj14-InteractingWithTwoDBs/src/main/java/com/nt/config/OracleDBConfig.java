package com.nt.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;



@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.nt.repository.prod",
                                            entityManagerFactoryRef = "oraEMF",
                                            transactionManagerRef = "oraTxMgmr")
public class OracleDBConfig {
	
	
	@Bean(name="oraDS")
	@ConfigurationProperties(prefix ="oracle.ds")
	@Primary
	public   DataSource createOracleDs() {
		return   DataSourceBuilder.create().build();
	}
	
	
	@Bean("oraEMF")
	@Primary
	public  LocalContainerEntityManagerFactoryBean  createLCEMFB(EntityManagerFactoryBuilder builder) {
		 //keep  JPA-Hibernate properties  in Map collection
		Map<String,String> map=new HashMap();
		map.put("hibernate.dialect","org.hibernate.dialect.Oracle10gDialect");
		map.put("hibernate.hbm2ddl.auto","update");
		map.put("hibernate.show_sql","true");
		map.put("hibernate.format_sql","true");
		
		// create  LocalContainerEntityManagerFactoryBean class object using  EntityManagerFactoryBuilder object
		return  builder.dataSource(createOracleDs())
				                .packages("com.nt.entity.prod")
				                .properties(map)
				                .build();
	}
	
	@Bean(name="oraTxMgmr")
	@Primary
	public   JpaTransactionManager   createOracleTxMgmr(@Qualifier("oraEMF") EntityManagerFactory factory) {
		return  new  JpaTransactionManager(factory);
	}

}
