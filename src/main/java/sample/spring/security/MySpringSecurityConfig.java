package sample.spring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;



@EnableWebSecurity
public class MySpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/index").permitAll().anyRequest().authenticated().and().formLogin()
				.loginPage("/index").loginProcessingUrl("/login").usernameParameter("name").passwordParameter("pass")
				.defaultSuccessUrl("/loginResult").and().logout().logoutSuccessUrl("/index").and().sessionManagement()
				.maximumSessions(1);

	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new Pbkdf2PasswordEncoder();
	}

	/*
	 * インメモリで試したとき
	 * 
	 * @Autowired public void configure(AuthenticationManagerBuilder auth) throws
	 * Exception { PasswordEncoder encoder =
	 * PasswordEncoderFactories.createDelegatingPasswordEncoder();
	 * auth.inMemoryAuthentication() .withUser("hoge")
	 * .password(encoder.encode("hoge")) .authorities(Collections.emptyList()); }
	 */

}
