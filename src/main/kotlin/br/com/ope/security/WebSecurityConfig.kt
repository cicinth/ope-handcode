package br.com.ope.security

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.password.PasswordEncoder

@EnableWebSecurity
open class WebSecurityConfig(private val userDetailsService: UserDetailsService,
                             private val passwordEncoderAndMatcher: PasswordEncoder)
    : WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity) {
        http.authorizeRequests()
            .antMatchers("/h2_console/**").permitAll()
            .antMatchers("/painel/admin/**").hasRole("ADMIN")
            .antMatchers("/painel/aluno/**").hasRole("ALUNO")
            .antMatchers("/painel/professor/**").hasRole("PROFESSOR")
            .and().formLogin().loginPage("/login").permitAll().successHandler(UrlRedirectAuthenticationSuccessHandler())
            .and().logout().logoutUrl("/logout").permitAll()
            .and().exceptionHandling().accessDeniedPage("/403")

        http.headers().frameOptions().disable()
    }

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.userDetailsService(userDetailsService)
            .passwordEncoder(passwordEncoderAndMatcher)
    }
}