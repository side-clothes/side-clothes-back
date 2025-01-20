package com.mong.mmbs.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.mong.mmbs.filter.JwtAuthenticationFilter;
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	
	@Autowired JwtAuthenticationFilter jwtAuthencationFilter;
	@Bean
	protected SecurityFilterChain configure(HttpSecurity httpSecurity) throws Exception {

		httpSecurity
			.cors().and()
			.csrf().disable()
			.httpBasic().disable()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
			.authorizeRequests().antMatchers("/", "/apis/auth/**", "/apis/category/**", "/apis/product/**", "/apis/order/").permitAll()
			.anyRequest().authenticated();
		
		httpSecurity.addFilterBefore(jwtAuthencationFilter, UsernamePasswordAuthenticationFilter.class);

		return httpSecurity.build();
	}
}