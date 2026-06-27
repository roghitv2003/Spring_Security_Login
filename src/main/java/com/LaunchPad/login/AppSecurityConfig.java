package com.LaunchPad.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.util.AntPathMatcher;


@Configuration
@EnableWebSecurity
public class AppSecurityConfig{
    @Autowired
    private MyUserDetailService userDetailsService;

    @Bean
    public AuthenticationProvider authenticationProvider()
    {
        DaoAuthenticationProvider provider= new DaoAuthenticationProvider(userDetailsService);
        provider.setPasswordEncoder(new BCryptPasswordEncoder()); //Bcrypt is uesd to secure password
        return provider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth ->auth
                        .requestMatchers("/login", "/logout-success", "/error",
                                "/WEB-INF/views/login.jsp",
                                "/WEB-INF/views/logout.jsp").permitAll()
                        .anyRequest().authenticated())
                .formLogin(from -> from
                        .loginPage("/login")
                        .loginProcessingUrl("/perform_login")
                        .defaultSuccessUrl("/", true)
                        .failureUrl("/login?error=true")
                        .permitAll())
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .invalidateHttpSession(true)
                        .clearAuthentication(true)
                        .logoutSuccessUrl("/logout-success")
                        .permitAll());
        return http.build();
    }

//    @Bean
//    protected UserDetailsService userDetailsService(){
//        List<UserDetails> users= new ArrayList<>();
//        users.add(User.withDefaultPasswordEncoder().username("roghit").password("1234").roles("USER").build());
//        return new InMemoryUserDetailsManager(users);
//    }
}
