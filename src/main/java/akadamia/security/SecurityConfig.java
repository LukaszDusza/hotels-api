package akadamia.security;

import akadamia.repositories.HotelRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableJpaRepositories(basePackageClasses = {UserRepository.class, RoleRepository.class, HotelRepository.class})
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private PasswordEncoder passwordEncoder;
    private CustomUserService customUserService;

    public SecurityConfig(PasswordEncoder passwordEncoder, CustomUserService customUserService) {
        this.passwordEncoder = passwordEncoder;
        this.customUserService = customUserService;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers("/login", "/register").permitAll()
            .and()
            .formLogin()
            .loginPage("/login")
            .loginProcessingUrl("/signin")
            .usernameParameter("username")
            .passwordParameter("password")
            .successHandler((req, res, auth) -> {
                res.sendRedirect("/home");
            })
            .failureUrl("/login?error='incorrect login or password'")
            .failureHandler((req, res, auth) -> {
            })
            .permitAll()
            .and()
            .exceptionHandling( (req) -> {
                req.accessDeniedPage("/home?message=Access denied!");
            })
            .logout()
            .logoutUrl("/logout")
            .logoutSuccessHandler((req, res, auth) -> {
                req.getSession().setAttribute("message", "You are logout.");
                res.sendRedirect("/home");
            })
            .permitAll();

        http.headers().frameOptions().disable();
        http.cors().disable();
        http.csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(customUserService)
                .passwordEncoder(passwordEncoder);


    }
}
