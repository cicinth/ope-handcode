package br.com.ope.controller

import br.com.ope.model.Administrador
import br.com.ope.model.Aluno
import br.com.ope.model.Professor
import br.com.ope.model.Usuario
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class PainelController {

    @GetMapping("/painel")
    fun index(@AuthenticationPrincipal usuario: Usuario?) : String {

        if (usuario == null)  return "redirect:/"

        return when (usuario) {
            is Aluno -> "redirect:/painel/aluno"
            is Professor -> "redirect:/painel/professor"
            is Administrador -> "redirect:/painel/admin"
            else -> "redirect:/"
        }
    }
}