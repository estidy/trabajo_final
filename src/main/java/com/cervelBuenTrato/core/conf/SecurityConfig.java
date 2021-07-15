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
		 * http.authorizeRequests().antMatchers("/", "/index", "/login").permitAll()
		 * .antMatchers("/users/**", "/users/abm_users").hasAnyRole("USER", "ADMIN")
		 * .antMatchers("/users/editUser/**", "/users/addUser/**",
		 * "/users/deleteUser").hasRole("ADMIN")
		 * .anyRequest().authenticated().and().formLogin().loginPage("/login").and().
		 * exceptionHandling() .accessDeniedPage("/templates_errors/403");
		 */
		http.csrf().disable().authorizeRequests().antMatchers("/", "/index", "/login").permitAll().and().formLogin()
				.loginPage("/login").defaultSuccessUrl("/users/abm_users", true).failureUrl("/loginError").and()
				.logout().deleteCookies("JSESSIONID").logoutSuccessUrl("/login");
	}

}
