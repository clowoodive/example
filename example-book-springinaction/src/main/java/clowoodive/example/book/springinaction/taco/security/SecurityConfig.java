package clowoodive.example.book.springinaction.taco.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity(debug = true)
// extends WebSecurityConfiguration가 deprecated되었음.
// https://spring.io/blog/2022/02/21/spring-security-without-the-websecurityconfigureradapter
//public class SecurityConfig extends WebSecurityConfiguration {
public class SecurityConfig {

    @Autowired
    DataSource datasource;

//    @Bean
//    public InMemoryUserDetailsManager userDetailsService(AuthenticationManagerBuilder auth) {
//        List<UserDetails> users = new ArrayList<>();
//
//        users.add(User
//                .withUsername("user1")
//                .password("{noop}password1")
//                .authorities("ROLE_USER")
//                .build()
//        );
//        users.add(User
//                .withUsername("user2")
//                .password("{noop}password2")
//                .authorities("ROLE_USER")
//                .build()
//        );
//
//        return new InMemoryUserDetailsManager(users);
//
////        auth.inMemoryAuthentication()
////                .withUser("user1")
////                .password("{noop}password1")
////                .authorities("ROLE_USER")
////                .and()
////                .withUser("user2")
////                .password("{noop}password2")
////                .authorities("ROLE_USER");
//    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests().antMatchers("/design", "/orders")
                .access("hasRole('ROLE_USER')")
                .antMatchers("/", "/**").access("permitAll")
//                .antMatchers(toH2Console()).permitAll()
                .and().headers().frameOptions().sameOrigin() // h2-console 로그인에 필요함(웹 콘솔에 사용되는 iframe에 대한 요청을 허용함)
                .and().csrf().disable() // h2-console 로그인에 필요함(웹 콘솔은 요청에 csrf 토큰을 사용하지 않음)
                .httpBasic()
        ;
        return http.build();
    }

    @Bean
    public UserDetailsManager users(DataSource dataSource) {
        List<UserDetails> users = new ArrayList<>();
        passwordEncoder().encode("pass1");
        users.add(User
                .withUsername("user1")
                .password(passwordEncoder().encode("pass1"))
                .authorities("ROLE_USER")
                .build()
        );
        users.add(User
                .withUsername("user2")
                .password(passwordEncoder().encode("pass2"))
                .authorities("ROLE_USER")
                .build()
        );

        JdbcUserDetailsManager userMan = new JdbcUserDetailsManager(dataSource);
        userMan.createUser(users.get(0));
        userMan.createUser(users.get(1));
        return userMan;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
