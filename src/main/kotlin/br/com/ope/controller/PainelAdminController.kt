package br.com.ope.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class PainelAdminController {

    @GetMapping("/painel/admin")
    fun index(model : Model) : String {
        return "painel/admin/index"
    }

}