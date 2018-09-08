package br.com.ope.repository

import br.com.ope.model.Disciplina
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface DisciplinaRepository : JpaRepository<Disciplina, UUID> {

}