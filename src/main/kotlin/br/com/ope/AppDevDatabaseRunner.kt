package br.com.ope

import br.com.ope.enumx.Role
import br.com.ope.model.Administrador
import br.com.ope.model.Aluno
import br.com.ope.model.Curso
import br.com.ope.model.Professor
import br.com.ope.repository.CursoRepository
import br.com.ope.repository.UsuarioRepository
import org.slf4j.LoggerFactory
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Component

@Component
//@Profile(value = ["dev","default"])
class AppDevDatabaseRunner(val cursoRepository: CursoRepository,
                           val usuarioRepository: UsuarioRepository) : ApplicationRunner{

    private val logger = LoggerFactory.getLogger(AppDevDatabaseRunner::class.java)
    override fun run(args: ApplicationArguments?) = iniciarBanco()

    fun iniciarBanco() {
        logger.info("Populando banco de DEV com dados simulados")

        val aluno = Aluno(nome = "Alan Faraj", ra = 1700041, senha = BCryptPasswordEncoder().encode("senha"), email = "aluno@email.com.br", ativo = true, permissoes = mutableSetOf(Role.ROLE_ALUNO))
        val curso = Curso("Analise de sistemas","ADS",4)

        val admin = Administrador(nome = "Administrador", email = "admin@email.com.br", senha = BCryptPasswordEncoder().encode("senha"), ativo = true, permissoes = mutableSetOf(Role.ROLE_ADMIN))
        val professor = Professor(nome = "Professor", email = "professor@email.com.br", senha = BCryptPasswordEncoder().encode("senha"), ativo = true, permissoes = mutableSetOf(Role.ROLE_PROFESSOR))

        usuarioRepository.save(professor)
        usuarioRepository.save(aluno)
        usuarioRepository.save(admin)
        cursoRepository.save(curso)

        logger.info("Finalizado setup dos dados simulados no banco")
    }

}