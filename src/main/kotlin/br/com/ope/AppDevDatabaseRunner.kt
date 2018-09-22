package br.com.ope

import br.com.ope.enumx.Role
import br.com.ope.model.*
import br.com.ope.repository.*
import org.slf4j.LoggerFactory
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Component
import java.util.*

@Component
//@Profile(value = ["dev","default"])
class AppDevDatabaseRunner(val cursoRepository: CursoRepository,
                           val eventoRepository: EventoRepository,
                           val tarefaRepository: TarefaRepository,
                           val alunoRepository: AlunoRepository,
                           val usuarioRepository: UsuarioRepository,
                           val grupoRepository: GrupoRepository,
                           val disciplinaRepository: DisciplinaRepository,
                           val turmaRepository: TurmaRepository) : ApplicationRunner{

    private val logger = LoggerFactory.getLogger(AppDevDatabaseRunner::class.java)
    override fun run(args: ApplicationArguments?) = iniciarBanco()

    fun iniciarBanco() {
        logger.info("Populando banco de com dados.")

        val ope1 = Disciplina(nome = "Oficina projeto empresa 1", sigla = "OPE1")
        disciplinaRepository.save(ope1)
        val ope2 = Disciplina(nome = "Oficina projeto empresa 2", sigla = "OPE2")
        disciplinaRepository.save(ope2)
        val ope3 = Disciplina(nome = "Oficina projeto empresa 3", sigla = "OPE3")
        disciplinaRepository.save(ope3)
        val ope4 = Disciplina(nome = "Oficina projeto empresa 4", sigla = "OPE4")
        disciplinaRepository.save(ope4)
        var ads = Curso("Analise de sistemas","ADS",4, disciplinaRepository.findAll())
        ads = cursoRepository.save(ads)

        var turmaA = Turma("A",1,2018,ads, mutableListOf(),Turma.Periodo.MANHA)
        turmaRepository.save(turmaA)
        var turmaB = Turma("B",1,2018,ads, mutableListOf(),Turma.Periodo.NOITE)
        turmaRepository.save(turmaB)
        var turmaC = Turma("C",1,2018,ads, mutableListOf(),Turma.Periodo.NOITE)
        turmaRepository.save(turmaC)

        val alan = Aluno(nome = "Alan Faraj", ra = 1700041, senha = BCryptPasswordEncoder().encode("senha"), email = "aluno@email.com.br", ativo = true, permissoes = mutableSetOf(Role.ROLE_ALUNO), turma = turmaA)
        val alex = Aluno(nome = "Javaboy", ra = 1700072, senha = BCryptPasswordEncoder().encode("senha"), email = "java@email.com.br", ativo = true, permissoes = mutableSetOf(Role.ROLE_ALUNO), turma = turmaA)
        val michael = Aluno(nome = "Michael", ra = 1700017, senha = BCryptPasswordEncoder().encode("senha"), email = "michael@email.com.br", ativo = true, permissoes = mutableSetOf(Role.ROLE_ALUNO), turma = turmaA)




        val admin = Administrador(nome = "Administrador", email = "admin@email.com.br", senha = BCryptPasswordEncoder().encode("senha"), ativo = true, permissoes = mutableSetOf(Role.ROLE_ADMIN))
        val yuri = Professor(nome = "Yuri", email = "professor@email.com.br", senha = BCryptPasswordEncoder().encode("senha"), ativo = true, permissoes = mutableSetOf(Role.ROLE_PROFESSOR))
        val fernando = Professor(nome = "Fernando", email = "fernando@email.com.br", senha = BCryptPasswordEncoder().encode("senha"), ativo = true, permissoes = mutableSetOf(Role.ROLE_PROFESSOR))


        usuarioRepository.save(admin)
        usuarioRepository.save(yuri)
        usuarioRepository.save(fernando)

        usuarioRepository.save(alan)
        usuarioRepository.save(michael)
        usuarioRepository.save(alex)
        val handcode = Grupo(nome = "Handcode", curso = ads, alunos = alunoRepository.findAll())

        grupoRepository.save(handcode)

        val rodolfo = Aluno(nome = "Rodolfo", ra = 1700047, senha = BCryptPasswordEncoder().encode("senha"), email = "rodolfo@email.com.br", ativo = true, permissoes = mutableSetOf(Role.ROLE_ALUNO), turma = turmaB)
        usuarioRepository.save(rodolfo)

        Grupo(nome = "Grupo do Rodolfo", curso = ads, alunos = mutableListOf(rodolfo))

        val tarefa = Tarefa(Date(), Date(), 1, mutableListOf(), "Lista de entregaveis.", "Entrega de parte da documentacao", ope1, ads, turmaRepository.findAllByCurso_idOrderBySemestreDesc(ads.id
                ?: UUID.randomUUID()))

        tarefaRepository.save(tarefa)

        val evento = Evento(Date(), "Lista de entregaveis.", "Entrega de parte da documentacao", ope1, ads, turmaRepository.findAllByCurso_idOrderBySemestreDesc(ads.id
                ?: UUID.randomUUID()), tarefa)

        eventoRepository.save(evento)

        logger.info("Finalizado setup dos dados simulados no banco")
    }

}