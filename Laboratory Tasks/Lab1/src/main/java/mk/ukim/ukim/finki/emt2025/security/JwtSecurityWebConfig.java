package mk.ukim.ukim.finki.emt2025.security;

import mk.ukim.ukim.finki.emt2025.config.CustomUsernamePasswordAuthenticationProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Profile("dev")
@Configuration
@EnableWebSecurity
public class JwtSecurityWebConfig {

    private final CustomUsernamePasswordAuthenticationProvider authenticationProvider;
    private final JwtFilter jwtFilter;

    public JwtSecurityWebConfig(CustomUsernamePasswordAuthenticationProvider authenticationProvider, JwtFilter jwtFilter) {
        this.authenticationProvider = authenticationProvider;
        this.jwtFilter = jwtFilter;
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowedOrigins(List.of("http://localhost:5173", "http://localhost:8181"));
        corsConfiguration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        corsConfiguration.setAllowedHeaders(List.of("Authorization", "Content-Type"));
        corsConfiguration.setAllowedHeaders(List.of("*"));
        corsConfiguration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration);
        return source;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors(corsCustomizer -> corsCustomizer.configurationSource(corsConfigurationSource()))
                .csrf(csrf -> csrf.disable())
                .authorizeRequests(auth -> auth
                                .anyRequest().permitAll());
//                .requestMatchers(
//                        "/swagger-ui/**",
//                        "/v3/api-docs/**",
//                        "/api-docs/**",
//                        "/swagger-resources/**",
//                        "/webjars/**",
//                        "/user/login",
//                        "/user/register"
//                ).permitAll()
//                .requestMatchers(
//                        "/books/by-author",
//                        "/authors/by-country",
//                        "/authors/names",
//                        "/authors/add",
//                        "/authors/edit/*",
//                        "/authors/delete/*"
//                ).hasAnyAuthority("ROLE_USER", "ROLE_LIBRARIAN")
//                .anyRequest()
//                .authenticated()
//                .and()
//                .sessionManagement(sessionManagementConfigurer ->
//                        sessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                )
//                .authenticationProvider(authenticationProvider)
//                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}