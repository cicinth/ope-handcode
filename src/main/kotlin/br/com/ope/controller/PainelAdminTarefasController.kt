package br.com.ope.controller

import br.com.ope.model.Evento
import br.com.ope.model.Tarefa
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class PainelAdminTarefasController {

    @GetMapping("/painel/admin/tarefas/novo")
    fun index(model : Model) : String {
        model.addAttribute("tarefa", Tarefa())
        return "painel/admin/tarefas/novo"
    }

}