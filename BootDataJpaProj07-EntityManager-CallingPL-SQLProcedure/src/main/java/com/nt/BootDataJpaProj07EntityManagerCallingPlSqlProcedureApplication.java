package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.runner.CallingPLSQLProcedureTest;

@SpringBootApplication
public class BootDataJpaProj07EntityManagerCallingPlSqlProcedureApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootDataJpaProj07EntityManagerCallingPlSqlProcedureApplication.class, args);
		ApplicationContext ctx=SpringApplication.run(BootDataJpaProj07EntityManagerCallingPlSqlProcedureApplication.class, args);
	    System.out.println("BootDataJpaProj07EntityManagerCallingPlSqlProcedureApplication.main()");
		CallingPLSQLProcedureTest runner=ctx.getBean("runner",CallingPLSQLProcedureTest.class);
		((ConfigurableApplicationContext) ctx).close();
	}

}
