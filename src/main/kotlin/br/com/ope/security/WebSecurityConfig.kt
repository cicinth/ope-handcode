package br.com.ope.security

import org.springframework.core.annotation.Order
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.util.matcher.AntPathRequestMatcher

@EnableWebSecurity
@Order(2)
open class WebSecurityConfig(private val userDetailsService: UserDetailsService,
                             private val passwordEncoderAndMatcher: PasswordEncoder)
    : WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity) {
        http.authorizeRequests()
            .antMatchers("/publico/**").permitAll()
            .antMatchers("/h2_console/**").hasRole("ADMIN")
            .antMatchers("/painel/admin/**").hasRole("ADMIN")
            .antMatchers("/painel/aluno/**").hasRole("ALUNO")
            .antMatchers("/painel/professor/**").hasRole("PROFESSOR")
            .and().formLogin().loginPage("/login").permitAll().successHandler(UrlRedirectAuthenticationSuccessHandler())
            .and().logout().logoutRequestMatcher(AntPathRequestMatcher("/logout")).logoutSuccessUrl("/")
            .and().exceptionHandling().accessDeniedPage("/403")
            .and().csrf().ignoringAntMatchers("/h2_console/**")
            .and().headers().frameOptions().sameOrigin()

    }

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.userDetailsService(userDetailsService)
            .passwordEncoder(passwordEncoderAndMatcher)
    }
}