package ua.pp.avmelnyk.junto.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

@EnableWebMvcSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("user").password("userpassword").roles("USER");
        auth.inMemoryAuthentication().withUser("admin").password("adminpassword").roles("ADMIN");
        auth.inMemoryAuthentication().withUser("superadmin").password("").roles("");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        http.addFilterBefore(filter,CsrfFilter.class);
        http
                .authorizeRequests()
                .antMatchers("/user/**").authenticated()
                .antMatchers("/books/**").authenticated()
                .antMatchers("/edituser/**").authenticated()
                .and()
                .formLogin().loginPage("/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .loginProcessingUrl("/spring_security_check")
                .and().logout().
                logoutUrl("/logout").
                logoutSuccessUrl("/");
    }
}
