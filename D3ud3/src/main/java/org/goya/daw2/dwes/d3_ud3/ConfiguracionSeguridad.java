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
					.requestMatchers("/", "/home").permitAll() // Admite que no precises de autenticacion PUBLICAS
					.anyRequest().authenticated() // Requiere iniciar sesion en cualquier otra pagina
				)
				.formLogin((form) -> form // En caso de intentar entrar en una pagina protegida te redirige al login 
										  // Siendo esta accesible para todos 	
					.loginPage("/login")
					.permitAll()
				)
				.logout(LogoutConfigurer::permitAll); // Permite a cualquiera cerrar sesion 
			// @formatter:on

			return http.build(); //Devuelve el objeto ya construido
		}

		@Bean
		PasswordEncoder passwordEncoder() { // Crea un objeto que hashea las passwds
			return new BCryptPasswordEncoder();
		}

		@Bean // Definicion de quien inicia sesion
		UserDetailsService userDetailsService(PasswordEncoder encoder) {
			String password = encoder.encode("password"); // Contraseña hasheada
			//Crea un usuario con nombre user, esa contraseña cifrada y el rol USER.
			UserDetails user = User.withUsername("user").password(password).roles("USER").build(); 
			String passwordAlex = encoder.encode("1234"); // Contraseña hasheada
			//Crea un usuario con nombre user, esa contraseña cifrada y el rol USER.
			UserDetails alex = User.withUsername("Alex").password(passwordAlex).roles("ADMIN").build(); 
			return new InMemoryUserDetailsManager(user , alex); // Guarda el usuario en la memoria de la applicacion
		}

	}

