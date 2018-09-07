package br.com.ope.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class PainelAlunoController {

    @GetMapping("/painel/aluno")
    fun index(model : Model) : String {

        return "painel/aluno/index"
    }

}