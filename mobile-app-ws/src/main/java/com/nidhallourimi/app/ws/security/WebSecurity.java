package com.nidhallourimi.app.ws.security;

import com.nidhallourimi.app.ws.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.servlet.Filter;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

    private Environment environment;
    private UserService userService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public WebSecurity(Environment environment,UserService userService,BCryptPasswordEncoder bCryptPasswordEncoder)
    {
        this.environment=environment;
        this.bCryptPasswordEncoder=bCryptPasswordEncoder;
        this.userService=userService;
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        /*http.authorizeRequests().antMatchers("/users/**").permitAll();*/
        http.authorizeRequests().antMatchers(HttpMethod.GET,"users/actuator/**").permitAll();
        http.authorizeRequests()

                .antMatchers("/**").hasIpAddress(environment.getProperty("gateway.ip"))

        .and().addFilter(getAuthenticationFilter());
        http.headers().frameOptions().disable();//for accessing h2 database


    }

    private AuthenticationFilter getAuthenticationFilter() throws Exception {
        AuthenticationFilter authenticationFilter =new AuthenticationFilter(userService,environment,authenticationManager());
        //authenticationFilter.setAuthenticationManager(authenticationManager());
        authenticationFilter.setFilterProcessesUrl(environment.getProperty("login.url.path"));
        return authenticationFilter;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder);
    }
}
