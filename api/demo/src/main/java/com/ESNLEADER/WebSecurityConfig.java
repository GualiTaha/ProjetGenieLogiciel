package com.ESNLEADER;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.ESNLEADER.service.CustomUserDetailsService;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private CustomUserDetailsService userDetailsService;
	
	
	@Override
	  protected void configure(AuthenticationManagerBuilder auth)
	    throws Exception {
	      auth.authenticationProvider(authenticationProvider());
	  }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
        .httpBasic().and()
        .cors().and().
        csrf().disable()
        .authorizeRequests()
      .antMatchers("/Inscription", "/Connexion","/users","/collabs/lister","/collabs/ajouter",
    		  "/collabs/modifier","/collabs/modifier"
    		  
    		  
    		  
    		  ).permitAll()
       .antMatchers(HttpMethod.GET).permitAll().antMatchers(HttpMethod.POST).permitAll()

        .anyRequest().permitAll();
 //      .anyRequest().authenticated();
		
			}

	  @Bean
	  public DaoAuthenticationProvider authenticationProvider() {
		  System.err.println("enter");
	      DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	      authProvider.setUserDetailsService(userDetailsService);
	      authProvider.setPasswordEncoder(bCryptPasswordEncoder());
	      return authProvider;
	  }
	  
	  @Bean
	  public BCryptPasswordEncoder bCryptPasswordEncoder() {
	      return new BCryptPasswordEncoder();
	  }
}
