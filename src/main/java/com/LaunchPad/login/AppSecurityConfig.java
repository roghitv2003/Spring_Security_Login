package com.LaunchPad.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;



@Configuration
@EnableWebSecurity
public class AppSecurityConfig{
    @Autowired
    private MyUserDetailService userDetailsService;

    @Bean
    public AuthenticationProvider authenticationProvider()
    {
        DaoAuthenticationProvider provider= new DaoAuthenticationProvider(userDetailsService);
        provider.setPasswordEncoder(new BCryptPasswordEncoder());
        return provider;
    }


//    @Bean
//    protected UserDetailsService userDetailsService(){
//        List<UserDetails> users= new ArrayList<>();
//        users.add(User.withDefaultPasswordEncoder().username("roghit").password("1234").roles("USER").build());
//        return new InMemoryUserDetailsManager(users);
//    }
}
