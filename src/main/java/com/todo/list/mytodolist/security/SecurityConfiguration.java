package com.todo.list.mytodolist.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		
		UserBuilder users = User.withDefaultPasswordEncoder();
		
        auth.inMemoryAuthentication()
            .withUser(users.username("user1").password("user1")
            .roles("USER"))
            .withUser(users.username("admin").password("admin")
                    .roles("USER"));
        
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
        .antMatchers("/","/todo/**").hasRole("USER")
        .antMatchers("/resources/**").permitAll()
        .and()
            .formLogin()
            .loginPage("/todo/loginPage")
            .loginProcessingUrl("/todo/authenticateTheUser")
			.permitAll()
		.and()
		.logout().permitAll();
    }
}
