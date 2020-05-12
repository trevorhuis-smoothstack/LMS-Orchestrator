package com.ss.training.lms.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Justin O'Brien
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("borrower").password(passwordEncoder().encode("borrowerPassword"))
				.roles("BORROWER").and().withUser("librarian").password(passwordEncoder().encode("librarianPassword"))
				.roles("LIBRARIAN", "BORROWER").and().withUser("admin")
				.password(passwordEncoder().encode("adminPassword")).roles("ADMIN", "LIBRARIAN", "BORROWER");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/lms/borrower/*").hasAnyRole("BORROWER", "LIBRARIAN", "ADMIN")
				.antMatchers("/lms/librarian/*").hasAnyRole("LIBRARIAN", "ADMIN").antMatchers("/lms/admin/*")
				.hasAnyRole("BORROWER", "LIBRARIAN", "ADMIN");
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
