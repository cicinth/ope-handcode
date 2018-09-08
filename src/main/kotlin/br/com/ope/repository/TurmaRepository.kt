package br.com.ope.repository

import br.com.ope.model.Turma
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*
interface TurmaRepository : JpaRepository<Turma, UUID> {
    fun findAllByCurso_idOrderBySemestreDesc(cursoId: UUID): List<Turma>
}