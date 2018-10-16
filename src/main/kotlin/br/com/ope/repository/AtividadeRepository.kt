package br.com.ope.repository

import br.com.ope.model.Atividade
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface AtividadeRepository : JpaRepository<Atividade, UUID>