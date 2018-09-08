package br.com.ope.controller.rest

import br.com.ope.model.Turma
import br.com.ope.repository.TurmaRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/rest/turmas")
class TurmaRestController {

    private val turmaRepository : TurmaRepository

    constructor(turmaRepository: TurmaRepository) {
        this.turmaRepository = turmaRepository
    }

    @GetMapping
    fun turmas (@RequestParam("cursoId") cursoId : UUID) :  List<Turma> {
        return turmaRepository.findAllByCurso_idOrderBySemestreDesc(cursoId)
    }

}