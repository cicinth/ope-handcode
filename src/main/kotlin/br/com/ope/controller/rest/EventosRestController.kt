package br.com.ope.controller.rest

import br.com.ope.model.Evento
import br.com.ope.repository.EventoRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/rest/eventos", "/api/v1/eventos"])
class EventosRestController {

    private val eventoRepository : EventoRepository

    constructor(eventoRepository: EventoRepository) {
        this.eventoRepository = eventoRepository
    }

    @GetMapping
    fun eventos() :  MutableList<Evento> {
        return eventoRepository.findAll()
    }

}