package br.com.ope.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class ErrorPageController {

    @RequestMapping("/403")
    fun forbidden(): String {
        return "403"
    }

    @RequestMapping("/500")
    fun internal(): String {
        return "500"
    }



}