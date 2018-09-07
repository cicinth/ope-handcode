package br.com.ope.controller

import br.com.ope.dto.mensagemDTO
import br.com.ope.model.Curso
import br.com.ope.repository.CursoRepository
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.mvc.support.RedirectAttributes
import java.util.*

@Controller
@RequestMapping("/painel/admin/cursos")
class PainelAdminCursosController {

    private val cursoRepository : CursoRepository

    constructor(cursoRepository: CursoRepository) {
        this.cursoRepository = cursoRepository
    }

    @GetMapping
    fun index(model : Model) : String {
        model.addAttribute("cursos", cursoRepository.findAll())
        return "painel/admin/cursos/index"
    }

    @GetMapping("/novo")
    fun novo(model : Model) : String {
        model.addAttribute("curso", Curso())
        return "painel/admin/cursos/novo"
    }

    @PostMapping("/novo")
    fun novoSalvar(model : Model, curso: Curso, redirectAttributes: RedirectAttributes) : String {
        cursoRepository.save(curso)
        redirectAttributes.addFlashAttribute("mensagem", mensagemDTO("Curso salvo!","Sucesso!", mensagemDTO.TipoMensagem.success ))
        return "redirect:/painel/admin/cursos"
    }

}