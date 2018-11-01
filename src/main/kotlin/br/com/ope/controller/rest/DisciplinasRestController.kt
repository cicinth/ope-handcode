package br.com.ope.controller.rest

import br.com.ope.model.Disciplina
import br.com.ope.repository.DisciplinaRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping(value = ["/rest/disciplinas","/api/v1/disciplinas"])
class DisciplinasRestController {

    private val disciplinaRepository : DisciplinaRepository

    constructor(disciplinaRepository: DisciplinaRepository) {
        this.disciplinaRepository = disciplinaRepository
    }

    @GetMapping
    fun disciplinas (@RequestParam("cursoId") cursoId : UUID) :  MutableList<Disciplina> {
        return disciplinaRepository.findAllByDataExclusaoIsNullAndCursos_idIn(arrayListOf(cursoId))
    }

}