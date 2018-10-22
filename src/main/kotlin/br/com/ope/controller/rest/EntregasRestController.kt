package br.com.ope.controller.rest

import br.com.ope.model.Entrega
import br.com.ope.repository.EntregaRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/rest/entregas", "/api/v1/entregas"])
class EntregasRestController {

    private val entregaRepository : EntregaRepository

    constructor(entregaRepository: EntregaRepository) {
        this.entregaRepository = entregaRepository
    }

    @GetMapping
    fun entregas(status: Entrega.Status?) :  List<Entrega> {
        if (status == null) {
            return entregaRepository.findAll()
        } else {
            return entregaRepository.findAllByStatus(status)
        }
    }

}