package br.com.ope.repository

import br.com.ope.model.Disciplina
import br.com.ope.model.Tarefa
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface DisciplinaRepository : JpaRepository<Disciplina, UUID> {
    fun findAllByDataExclusaoIsNull(): MutableList<Disciplina>
    fun findAllByDataExclusaoIsNullAndCursos_idIn(cursoId: MutableList<UUID>): MutableList<Disciplina>
    fun findAllByTarefas(tarefa: Tarefa): MutableList<Disciplina>
}