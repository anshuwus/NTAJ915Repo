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
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages ="com.nt.repo.promotions",
                        entityManagerFactoryRef = "mysqlemf",
                        transactionManagerRef = "mysqlTxMgmr")
public class MySQLDBConfig {
	
	@Bean
	@ConfigurationProperties(prefix="mysql.db")
	public DataSource createMySQLDs() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean(name="mysqlemf")
	public LocalContainerEntityManagerFactoryBean createMySQLEntityManagerFactoryBean(EntityManagerFactoryBuilder builder) {
		//create Map object having hibernate properties
		Map<String,Object> props=new HashMap();
		props.put("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
		props.put("hibernate.hbm2ddl.auto", "update");
		props.put("hibernate.show_sql","true");
		props.put("hibernate.format_sql","true");
	
		//create and return LocalContainerEntityManagerFactoryBean class object which makes EntityManagerFactory as the spring bean
		return builder.dataSource(createMySQLDs()) //datasource
				.packages("com.nt.model.promotions")//model class packages
				.build();
	}
	
	@Bean(name="mysqlTxMgmr")
	public PlatformTransactionManager createMysqlTxMgmr(@Qualifier("mysqlemf") EntityManagerFactory factory) {
		return new JpaTransactionManager(factory);
	}
}
