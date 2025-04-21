package kg.attractor.jobsearch.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor

public class SecurityConfig {
  private final DataSource dataSource;

  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    String fetchUserQuery = "select email, password, enabled " +
            "from users " +
            "where email = ?";
    String fetchAuthorityQuery = "SELECT u.email, r.role, a.authority " +
            "FROM users u " +
            "JOIN usr_roles ur ON u.email = ur.usr_id " +
            "JOIN role r ON ur.role_id = r.id " +
            "JOIN roles_authorities ra ON r.id = ra.role_id " +
            "JOIN authority a ON ra.authority_id = a.id " +
            "WHERE u.email = ?";


    auth.jdbcAuthentication()
            .dataSource(dataSource)
            .usersByUsernameQuery(fetchUserQuery)
            .authoritiesByUsernameQuery(fetchAuthorityQuery);
  }
  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
            .sessionManagement(session ->
                    session.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
            )

            .httpBasic(Customizer.withDefaults())
            .formLogin(form -> form
                    .loginPage("/login")
                    .permitAll()
                    .defaultSuccessUrl("/home", true)
            )
            .logout(AbstractHttpConfigurer::disable)
            .csrf(AbstractHttpConfigurer::disable)
            .authorizeHttpRequests(authorize -> authorize
                    .requestMatchers("/login", "/auth/register","/vacancies","/profile/*","/home" ).permitAll()

                    .anyRequest().authenticated()
            );

    return http.build();
  }

}
