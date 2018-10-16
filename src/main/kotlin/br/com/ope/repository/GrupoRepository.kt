package br.com.ope.repository

import br.com.ope.model.Grupo
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface GrupoRepository : JpaRepository<Grupo, UUID> {
    fun findAllByAlunos_idIn(asList: List<UUID?>): Any
}