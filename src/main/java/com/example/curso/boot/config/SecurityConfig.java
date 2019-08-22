package com.example.curso.boot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {


	@Autowired
	@Qualifier("userDetailsService")
	private UserDetailsService userDetailsService;

	@Autowired
	private MyAccessDeniedHandler accessDeniedHandler;


	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
		.authorizeRequests()
		.antMatchers(
				"/",
				"/js/**",
				"/css/**",
				"/img/**",
				"/webjars/**").permitAll()
		.antMatchers("/departamentos/**").hasAnyRole("ADMIN")
		.antMatchers("/funcionarios/**").hasAnyRole("ADMIN")
		.antMatchers("/cargo/**").access("hasRole('USER')")
		//.antMatchers("/home").authenticated()
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/login")
		.permitAll()
		.and()
		.logout()
		.invalidateHttpSession(true)
		.clearAuthentication(true)
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/login?logout")
		.permitAll()
		.and()
		.exceptionHandling().accessDeniedHandler(accessDeniedHandler);
		//.exceptionHandling().accessDeniedPage("/access-denied");

		//http.exceptionHandling().accessDeniedPage("/access-denied");

		/*AQUI ESTOU INFORMANDO QUE QUALQUER REQUEST TEM ACESSO AO DIRETÓRIO src/main/resources */
		http.authorizeRequests().antMatchers("/resources/**").permitAll().anyRequest().permitAll();


		//-------------------------------------------------------------------------	
		//
		//		http.csrf().disable()
		//		.authorizeRequests()
		//		.antMatchers("/configuration/**", "/swagger*/**", "/webjars/**").permitAll()
		//		.antMatchers("/", "/home").permitAll()
		//		.antMatchers(
		//                HttpMethod.GET,
		//                "/",
		//                "/**/*.html",
		//                "/**/*.{png,jpg,jpeg,svg.ico}",
		//                "/**/*.css",
		//                "/**/*.js"
		//        ).permitAll()
		//		.antMatchers("/cargo/**").hasAnyRole("ADMIN")
		//		.antMatchers("/departamento/**", "/funcionario/**").hasAnyRole("USER")
		//		.anyRequest().authenticated()
		//		.and()
		//		.formLogin()
		//		.loginPage("/login").permitAll()
		//		.defaultSuccessUrl("/home")
		//		.and()
		//		.logout().permitAll()
		//		.and()
		//		.exceptionHandling()
		//		.accessDeniedHandler(accessDeniedHandler);
		//		
		//	
	}
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	/*	auth
		.inMemoryAuthentication().passwordEncoder(encoder)
		.withUser("user").password(encoder.encode("user")).roles("USER")
		.and()
		.withUser("admin").password(encoder.encode("admin")).roles("USER", "ADMIN");*/
		

		auth.userDetailsService(userDetailsService).passwordEncoder(encoder);
	}

}