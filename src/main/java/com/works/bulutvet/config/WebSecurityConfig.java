package com.works.bulutvet.config;

import com.works.bulutvet.services.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    final UserService userService;

    public WebSecurityConfig(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(userService.encoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/dashboard/**").permitAll()
                .antMatchers("/newCustomerAdd/**").permitAll()
                .antMatchers("/register/**").permitAll()
                .antMatchers("/calendar/**").permitAll()
                .antMatchers("/CategoryDescription/**").permitAll()
                .antMatchers("/vendor/**").permitAll()
                .antMatchers("/newCaseDescription/**").permitAll()
                .antMatchers("/settings/**").permitAll()
                .antMatchers("/depo/**").permitAll()
                .antMatchers("/laboratuvar/**").hasRole("DOCTOR")
                .antMatchers("/productDescription/**").permitAll()
                .antMatchers("/productDetail/**").permitAll()
                .antMatchers("/vaccineDescription/**").permitAll()
                .antMatchers("/vaccineDetail/**").permitAll()
                .antMatchers("/labAnimalDetail/**").permitAll()
                .antMatchers("/labCustomerDetail/**").permitAll()
                .antMatchers("/customerSearch/**").permitAll()
                .antMatchers("/myAccount/**").permitAll()
                .antMatchers("/404/**").permitAll()
                .antMatchers("/agenda/**").hasRole("ADMIN")
                .antMatchers("/").permitAll()
                .anyRequest().authenticated()
                .and()
                .csrf().disable()
                .formLogin().loginPage("/login").defaultSuccessUrl("/dashboard", true).permitAll()
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
               .deleteCookies("JSESSIONID")
                .invalidateHttpSession(true)
                .logoutSuccessHandler(userService)
                .permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/403");

    }
    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**", "/fontawesome-free-5.15.4-web/**","/sitecss/**","/vendor.js","/categoryDescription.js","/depo.js","/newCaseDescription.js","/agenda.js","/newCustomerAdd.js","/vaccineDescription.js","/productDescription.js","/dist/tui-calendar.css","/css/default.css","/css/icons.css","/dist/tui-calendar.js","/js/data/calendars.js","/js/data/schedules.js","/js/app.js","/calendar/**","/fonts/**","js/farmVaccine.js","js/laboratuvar.js","js/customerSearch.js","js/sales.js","/uploads/**","js/dashboard.js","js/payAction.js","js/clinic.js","css/sidebar.css");
    }



}
