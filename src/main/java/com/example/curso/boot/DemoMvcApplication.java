package com.example.curso.boot;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoMvcApplication {

	
	//https://www.codebyamir.com/blog/user-account-registration-with-spring-boot   -- bom
	
	//https://memorynotfound.com/spring-boot-spring-security-thymeleaf-form-login-example/
	//https://javabeginnerstutorial.com/spring-boot/making-spring-boot-thymeleaf-crud-application/
	
	//https://www.mkyong.com/spring-boot/spring-boot-spring-security-thymeleaf-example/
	//https://memorynotfound.com/spring-boot-spring-security-thymeleaf-form-login-example/
	//http://www.ciceroednilson.com.br/criando-uma-aplicacao-web-com-spring-boot-thymeleaf-material-designer-lite-e-oracle-parte-4-configurando-o-spring-security/

	//https://useiconic.com/open
	
	// jar tvf target/myproject-0.0.1-SNAPSHOT.jar
	//https://www.guj.com.br/t/mostrar-erro-na-tela-com-thymeleaf/355343
	//https://www.logicbig.com/tutorials/spring-framework/spring-boot/custom-thymeleaf-error-page.html
	//http://www.matera.com/blog/post/crud-com-spring-e-thymeleaf
	
	public static void main(String[] args) {
		SpringApplication.run(DemoMvcApplication.class, args);
	}
	
	
//	@Bean
//    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
//        return args -> {
//
//            System.out.println("Let's inspect the beans provided by Spring Boot:");
//            String[] beanNames = ctx.getBeanDefinitionNames();
//            Arrays.sort(beanNames);
//            for (String beanName : beanNames) {
//                System.out.println(beanName);
//            }
//
//        };
//    }
	
//	@Bean  
//	   public LocaleResolver localeResolver(){  
//	      return new FixedLocaleResolver(new Locale("pt", "BR"));  
//	   }  
	
	
//	 @Bean
//	    public LocaleResolver localeResolver(){
//	        SessionLocaleResolver r = new SessionLocaleResolver();
//	        r.setDefaultLocale(Locale.US);
//	        return r;
//	    }
	
	
}
