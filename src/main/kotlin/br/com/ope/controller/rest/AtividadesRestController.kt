package br.com.ope.controller.rest

import br.com.ope.model.Atividade
import br.com.ope.repository.AtividadeRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/rest/atividades", "/api/v1/atividades"])
class AtividadesRestController {

    private val atividadeRepository : AtividadeRepository

    constructor(atividadeRepository: AtividadeRepository) {
        this.atividadeRepository = atividadeRepository
    }

    @GetMapping
    fun atividades() :  List<Atividade> {
        return atividadeRepository.findAll()
    }

}