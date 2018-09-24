package br.com.ope.repository

import br.com.ope.model.Administrador
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ProfessorRepository : JpaRepository<Administrador, UUID>