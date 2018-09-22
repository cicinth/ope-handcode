package br.com.ope.repository

import br.com.ope.model.Evento
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface EventoRepository : JpaRepository<Evento, UUID>