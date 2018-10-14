package br.com.ope.controller

import br.com.ope.repository.GrupoRepository
import br.com.ope.vo.MensagemVO
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.mvc.support.RedirectAttributes
import java.util.*

@Controller
@RequestMapping("/painel/admin/grupos")
class PainelAdminGruposController {

    private val grupoRepository : GrupoRepository

    constructor(grupoRepository: GrupoRepository) {
        this.grupoRepository = grupoRepository
    }

    @GetMapping
    fun index(model : Model) : String {
        model.addAttribute("grupos", grupoRepository.findAll())
        return "painel/admin/grupos/index"
    }

    @GetMapping("/{id}")
    fun detalhe(model : Model, @PathVariable id : UUID, redirectAttributes: RedirectAttributes) : String {

        val grupo = grupoRepository.findById(id)

        if (!grupo.isPresent) return redirectGrupoNaoEncontrado(model, redirectAttributes)

        model.addAttribute("grupo", grupo.get())
        return "painel/admin/grupos/detalhe"
    }

    private fun redirectGrupoNaoEncontrado(model: Model, redirectAttributes: RedirectAttributes): String {
        redirectAttributes.addFlashAttribute("mensagem", MensagemVO("Grupo não encontrado!","Erro!", MensagemVO.TipoMensagem.danger ))
        return "redirect:/painel/admin/grupos"
    }

}