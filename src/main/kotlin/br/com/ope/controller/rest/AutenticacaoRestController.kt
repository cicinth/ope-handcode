package br.com.ope.controller.rest

import br.com.ope.model.Usuario
import br.com.ope.security.jwt.auth.JwtAuthenticationToken
import org.springframework.http.ResponseEntity
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/api/v1/me"])
class AutenticacaoRestController {

    val userDetailsService : UserDetailsService

    constructor(userDetailsService: UserDetailsService) {
        this.userDetailsService = userDetailsService
    }

    @GetMapping
    fun detalhesUsuarioAutenticado(token: JwtAuthenticationToken): ResponseEntity<*> {
        val userContext = token.getPrincipal() as Usuario
        val usuario = userDetailsService.loadUserByUsername(userContext.email) ?: throw UsernameNotFoundException("Usuário não encontrado: " + userContext.email)


        return ResponseEntity.ok(usuario)
    }

}