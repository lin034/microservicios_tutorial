package com.pildoraslin.aurrera.configuracion;

import com.pildoraslin.aurrera.seguridad.PerzonalizarCustomDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SeguridadProyecto {

    @Autowired
    PerzonalizarCustomDetailService detailsService;

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    /*@Bean
    public UserDetailsService userDetailsService() {

        //InMemoryUserDetailsManager  userDetailsService =

        var  userDetailsService =
                new InMemoryUserDetailsManager();

        UserDetails user = User.withUsername("lalin")
                .password("lalin")
                .roles("ADMIN")
                .build();
        var user2 = User.withUsername("maria")
                .password("maria")
                .roles("USER")
                .build();

        userDetailsService.createUser(user);
        userDetailsService.createUser(user2);

        return userDetailsService;
    }*/

    @Bean
    public PasswordEncoder passwordEncoder(){

        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
                .cors().and()
                .csrf().disable().authorizeHttpRequests()
                //.requestMatchers("/clientes").hasRole("ADMIN")
                .requestMatchers(HttpMethod.GET, "/clientes").permitAll()
                //.requestMatchers("/user").permitAll()
                .anyRequest().authenticated()
                //.and().httpBasic();
                .and().formLogin();




        return http.build();
    }
}
