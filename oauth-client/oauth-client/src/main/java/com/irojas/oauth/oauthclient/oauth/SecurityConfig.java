package com.irojas.oauth.oauthclient.oauth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests((oauthHttp) -> oauthHttp
			.requestMatchers(HttpMethod.GET,"/authorized").permitAll()
			.anyRequest().authenticated())
			.oauth2Login((login)-> login.loginPage("/oauth2/authorization/oauth-client"))
			.oauth2Client(Customizer.withDefaults());
		return http.build();
	}
}
