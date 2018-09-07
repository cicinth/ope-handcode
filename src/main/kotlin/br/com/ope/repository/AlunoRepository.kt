package br.com.ope.repository

import br.com.ope.model.Aluno
import br.com.ope.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import java.util.*

interface AlunoRepository : JpaRepository<Aluno, UUID>
