package br.com.ope.repository

import br.com.ope.model.Aluno
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface AlunoRepository : JpaRepository<Aluno, UUID> {
    fun findOneByRa(ra: Long) : Optional<Aluno>
    fun findOneByEmail(email: String): Optional<Aluno>
}
