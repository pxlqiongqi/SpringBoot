/**
 * 
 */
package com.pxl.configurations.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin()
			.loginPage("/login/html").loginProcessingUrl("/authentication/form")
			.and()
			.authorizeRequests()
			.antMatchers("/login/html").permitAll()//匹配到这个页面直接通过验证
			.anyRequest()
			.authenticated()
			.and().csrf().disable()//跨站防护功能关闭
			;
		/*http.httpBasic()
			.and()
			.authorizeRequests()
			.anyRequest()
			.authenticated();*/
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
		
	}
}
