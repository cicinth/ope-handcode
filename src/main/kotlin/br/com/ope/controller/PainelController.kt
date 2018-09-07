package br.com.ope.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class PainelController {

    @GetMapping("/painel")
    fun index() : String {
        return "redirect:/"
    }

}