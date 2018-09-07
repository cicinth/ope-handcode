package br.com.ope.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HomeController {

    @GetMapping("/")
    fun index(model : Model) : String {

        return "home/index"
    }

    @GetMapping("/cursos")
    fun grupos(model : Model) : String {

        return "home/cursos"
    }

}