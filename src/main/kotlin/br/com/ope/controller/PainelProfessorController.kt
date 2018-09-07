package br.com.ope.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class PainelProfessorController {

    @GetMapping("/painel/professor")
    fun index(model : Model) : String {

        return "painel/professor/index"
    }

}