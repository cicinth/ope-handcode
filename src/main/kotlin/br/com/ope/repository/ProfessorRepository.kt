package br.com.ope.repository

import br.com.ope.model.Administrador
import br.com.ope.model.Curso
import br.com.ope.model.Grupo
import br.com.ope.model.Professor
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ProfessorRepository : JpaRepository<Administrador, UUID>