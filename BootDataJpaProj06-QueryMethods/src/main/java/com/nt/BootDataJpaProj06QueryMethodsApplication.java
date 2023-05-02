package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.runner.QueryMethodsTestRunner;

@SpringBootApplication
public class BootDataJpaProj06QueryMethodsApplication {

	public static void main(String[] args) throws Exception {
		ApplicationContext ctx=SpringApplication.run(BootDataJpaProj06QueryMethodsApplication.class, args);
		/*QueryMethodsTestRunner runner=ctx.getBean("queryMethodsTestRunner",QueryMethodsTestRunner.class);
		runner.run("Hi");
		*/
		System.out.println("BootDataJpaProj06QueryMethodsApplication.main()");
		((ConfigurableApplicationContext) ctx).close();
	}

}
