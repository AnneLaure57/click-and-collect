package fr.ul.miage.clickandcollect.core;

import fr.ul.miage.clickandcollect.core.security.DBAuthenticationProvider;
import fr.ul.miage.clickandcollect.core.security.MD5Checker;
import fr.ul.miage.clickandcollect.core.security.SecurityProperties;
import fr.ul.miage.clickandcollect.core.security.UserDetailsServiceFactory;
import fr.ul.miage.clickandcollect.users.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import static fr.ul.miage.clickandcollect.core.security.StoreType.IN_DB;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.OPTIONS;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final SecurityProperties        properties;
    private final UserRepository            userRepository;
    private final UserDetailsServiceFactory factory;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/actuator/info").permitAll()
                .antMatchers("/actuator/health").permitAll()
                .anyRequest()
                .authenticated();

        if (properties.getStoreType() == IN_DB) {
            final var detailsService = factory.getInDb(userRepository);

            http.authenticationProvider(
                    new DBAuthenticationProvider(
                            detailsService,
                            new MD5Checker()
                    )
            );
        } else {
            http.userDetailsService(factory.getInMemory());
        }

        http.httpBasic();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers(OPTIONS, "/**")
                .antMatchers(GET, "/favicon.ico");
    }
}
