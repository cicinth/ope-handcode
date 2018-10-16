package br.com.ope.controller

import br.com.ope.model.Evento
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class PainelAdminEventosController {

    @GetMapping("/painel/admin/eventos/novo")
    fun index(model : Model) : String {
        model.addAttribute("evento", Evento())
        return "painel/admin/eventos/novo"
    }

}