package br.com.ope.controller.rest

import br.com.ope.model.Curso
import br.com.ope.repository.CursoRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/rest/cursos")
class CursosRestController {

    private val cursoRepository : CursoRepository

    constructor(cursoRepository: CursoRepository) {
        this.cursoRepository = cursoRepository
    }

    @GetMapping
    fun cursos () :  List<Curso> {
        return cursoRepository.findAllByDataExclusaoIsNull()
    }

}