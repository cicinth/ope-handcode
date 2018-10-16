package br.com.ope.controller.rest

import br.com.ope.model.Grupo
import br.com.ope.model.Usuario
import br.com.ope.repository.AtividadeRepository
import br.com.ope.repository.GrupoRepository
import br.com.ope.security.jwt.auth.JwtAuthenticationToken
import org.springframework.http.ResponseEntity
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping(value = ["/api/v1/me", "/api/v1/eu"])
class UsuarioAutenticadoRestController {

    val userDetailsService : UserDetailsService
    val ativiadeRepository: AtividadeRepository
    val grupoRepository : GrupoRepository

    constructor(userDetailsService: UserDetailsService, ativiadeRepository: AtividadeRepository, grupoRepository: GrupoRepository) {
        this.userDetailsService = userDetailsService
        this.ativiadeRepository = ativiadeRepository
        this.grupoRepository = grupoRepository
    }


    @GetMapping
    fun detalhesUsuarioAutenticado(token: JwtAuthenticationToken): ResponseEntity<*> {
        val userContext = token.getPrincipal() as Usuario
        val usuario = userDetailsService.loadUserByUsername(userContext.email) ?: throw UsernameNotFoundException("Usuário não encontrado: " + userContext.email)
        return ResponseEntity.ok(usuario)
    }

    @GetMapping("/atividades")
    fun agendamentosUsuarioAutenticado(token: JwtAuthenticationToken): ResponseEntity<*> {
        val userContext = token.getPrincipal() as Usuario
        val usuario = userDetailsService.loadUserByUsername(userContext.email) ?: throw UsernameNotFoundException("Usuário não encontrado: " + userContext.email)
        val atividades = ativiadeRepository.findAll()
        return ResponseEntity.ok(atividades)
    }

    @GetMapping("/grupos")
    fun grupos(token: JwtAuthenticationToken): ResponseEntity<*> {
        val userContext = token.getPrincipal() as Usuario
        val usuario = userDetailsService.loadUserByUsername(userContext.email) ?: throw UsernameNotFoundException("Usuário não encontrado: " + userContext.email)

        val grupos = grupoRepository.findAllByAlunos_idIn(Arrays.asList(userContext.id))
        return ResponseEntity.ok(grupos)
    }

}