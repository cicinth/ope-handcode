package br.com.ope.controller.rest

import br.com.ope.model.Entrega
import br.com.ope.model.Usuario
import br.com.ope.repository.EntregaRepository
import br.com.ope.repository.GrupoRepository
import br.com.ope.repository.TarefaRepository
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
    val tarefaRepository: TarefaRepository
    val grupoRepository : GrupoRepository
    val entregaRepository: EntregaRepository

    constructor(userDetailsService: UserDetailsService, tarefaRepository: TarefaRepository, grupoRepository: GrupoRepository, entregaRepository: EntregaRepository) {
        this.userDetailsService = userDetailsService
        this.tarefaRepository = tarefaRepository
        this.grupoRepository = grupoRepository
        this.entregaRepository = entregaRepository
    }


    @GetMapping
    fun detalhesUsuarioAutenticado(token: JwtAuthenticationToken): ResponseEntity<*> {
        val userContext = token.principal as Usuario
        val usuario = userDetailsService.loadUserByUsername(userContext.email) ?: throw UsernameNotFoundException("Usuário não encontrado: " + userContext.email)
        return ResponseEntity.ok(usuario)
    }

    @GetMapping("/grupos")
    fun grupos(token: JwtAuthenticationToken): ResponseEntity<*> {
        val userContext = token.principal as Usuario

        val grupos = grupoRepository.findAllByAlunos_idIn(Arrays.asList(userContext.id))
        return ResponseEntity.ok(grupos)
    }

    @GetMapping("/entregas")
    fun entregas(token: JwtAuthenticationToken, status: Entrega.Status?): ResponseEntity<*> {
        val userContext = token.principal as Usuario
        var entregas : MutableList<Entrega> = mutableListOf<Entrega>()

        if (status == null) {
            entregas = entregaRepository.findAll()
        } else {
            entregas = entregaRepository.findAllByStatus(status)
        }

        return ResponseEntity.ok(entregas)
    }

}