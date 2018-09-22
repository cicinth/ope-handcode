package br.com.ope.controller.rest

import br.com.ope.model.Evento
import br.com.ope.repository.EventoRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/rest/eventos")
class EventosRestController {

    private val eventoRepository : EventoRepository

    constructor(eventoRepository: EventoRepository) {
        this.eventoRepository = eventoRepository
    }

    @GetMapping
    fun eventos() :  List<Evento> {
        return eventoRepository.findAll()
    }

}