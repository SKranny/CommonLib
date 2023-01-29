package security.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import security.JwtPerRequestFilter;
import security.utils.JwtService;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain (HttpSecurity http) throws Exception {
       return http
               .csrf().disable()
               .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
               .and()
               .headers().frameOptions().disable()
               .and()
               .exceptionHandling()
               .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
               .and()
               .addFilterBefore(jwtPerRequestFilter(), UsernamePasswordAuthenticationFilter.class)
               .build();
    }

    @Bean
    public JwtPerRequestFilter jwtPerRequestFilter() {
        return new JwtPerRequestFilter(jwtService());
    }
    @Bean
    public JwtService jwtService() {
        return new JwtService();
    }
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
