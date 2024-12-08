package com.floriano.portfolio.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.SessionManagementConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextRepository;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfig {

	@Autowired
	private UserAuthenticationProviderImpl authenticationManager;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((authorize) -> authorize
				.requestMatchers("/login", "/resources/**", "/css/**", "/js/**", "/img/**", "/publico/**",
						"/certificaciones", "/experiencia", "/estudios", "/cursos", "/inicio")
				.permitAll().requestMatchers("/privado/**").hasAnyRole("ADMINISTRADOR").anyRequest().authenticated())
				.formLogin(form -> form.loginPage("/login").permitAll().loginProcessingUrl("/login")
						.defaultSuccessUrl("/privado/miperfil", true));

		SecurityContextRepository securityContextRepository = new HttpSessionSecurityContextRepository();
		// storing the session
		http.securityContext((context) -> context.securityContextRepository(securityContextRepository));

		// session management
		http.sessionManagement((session) -> {
			session.maximumSessions(1).maxSessionsPreventsLogin(true);
			session.sessionFixation(SessionManagementConfigurer.SessionFixationConfigurer::newSession);
			session.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED);
		});

		// auth provider for connect DAO
		http.authenticationProvider(authenticationManager);
		return http.build();
	}

}
