package br.com.ope.controller.rest

import br.com.ope.model.Tarefa
import br.com.ope.repository.TarefaRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/rest/tarefas", "/api/v1/tarefas"])
class TarefasRestController {

    private val tarefaRepository : TarefaRepository

    constructor(tarefaRepository: TarefaRepository) {
        this.tarefaRepository = tarefaRepository
    }

    @GetMapping
    fun tarefas() :  List<Tarefa> {
        return tarefaRepository.findAll()
    }

}