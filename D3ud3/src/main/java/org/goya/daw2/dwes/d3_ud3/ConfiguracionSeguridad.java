package org.goya.daw2.dwes.d3_ud3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // Declara ser una clase de ajustes
@EnableWebSecurity // Activa Spring Security
public class ConfiguracionSeguridad {
	

		@Bean 
		// Reglas de acceso 
		SecurityFilterChain securityFilterChain(HttpSecurity http) {
			// @formatter:off
			http
				.authorizeHttpRequests((requests) -> requests
					.requestMatchers("/", "/home").permitAll() // Admite que no precises de autenticacion 
					.anyRequest().authenticated() // Requiere iniciar sesion en cualquier otra pagina
				)
				.formLogin((form) -> form 
					.loginPage("/login")
					.permitAll()
				)
				.logout(LogoutConfigurer::permitAll);
			// @formatter:on

			return http.build();
		}

		@Bean
		PasswordEncoder passwordEncoder() {
			return new BCryptPasswordEncoder();
		}

		@Bean
		UserDetailsService userDetailsService(PasswordEncoder encoder) {
			String password = encoder.encode("password");
			UserDetails user = User.withUsername("user").password(password).roles("USER").build();
			return new InMemoryUserDetailsManager(user);
		}

	}

