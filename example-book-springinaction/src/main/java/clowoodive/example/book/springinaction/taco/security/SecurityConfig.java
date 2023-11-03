package clowoodive.example.book.springinaction.taco.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
// extends WebSecurityConfiguration가 deprecated되었음.
// https://spring.io/blog/2022/02/21/spring-security-without-the-websecurityconfigureradapter
//public class SecurityConfig extends WebSecurityConfiguration {
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests().antMatchers("/design", "/orders")
                .access("hasRole('ROLE_USER')")
                .antMatchers("/", "/**").access("permitAll")
                .and()
                .httpBasic();
        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService(AuthenticationManagerBuilder auth) {
        List<UserDetails> users = new ArrayList<>();

        users.add(User
                .withUsername("user1")
                .password("{noop}password1")
                .authorities("ROLE_USER")
                .build()
        );
        users.add(User
                .withUsername("user2")
                .password("{noop}password2")
                .authorities("ROLE_USER")
                .build()
        );

        return new InMemoryUserDetailsManager(users);

//        auth.inMemoryAuthentication()
//                .withUser("user1")
//                .password("{noop}password1")
//                .authorities("ROLE_USER")
//                .and()
//                .withUser("user2")
//                .password("{noop}password2")
//                .authorities("ROLE_USER");
    }
}
