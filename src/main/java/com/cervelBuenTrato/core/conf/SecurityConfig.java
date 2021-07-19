package com.cervelBuenTrato.core.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsService userDetailsService;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception {
		build.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// permisos a usuarios
		/*
		 * http .authorizeRequests().antMatchers("/oauth/token", "/oauth/authorize**",
		 * "/publica").permitAll(); // .anyRequest().authenticated();
		 * 
		 * http.requestMatchers().antMatchers("/privada") // Denegamos el acceso a
		 * "/privada" .and().authorizeRequests()
		 * .antMatchers("/privada").access("hasRole('USER')")
		 * .and().requestMatchers().antMatchers("/admin") // Denegamos el acceso a
		 * "/admin" .and().authorizeRequests()
		 * .antMatchers("/admin").access("hasRole('ADMIN')");
		 */
		http.csrf().disable().authorizeRequests().antMatchers("/", "/index", "/login", "/register").permitAll()
				.antMatchers("/users/abm_users/*").hasRole("ADMIN").and().formLogin().loginPage("/login")
				.defaultSuccessUrl("/users/homeProfile", true).failureUrl("/loginError").and().logout()
				.deleteCookies("JSESSIONID").logoutSuccessUrl("/login");
	}

}
