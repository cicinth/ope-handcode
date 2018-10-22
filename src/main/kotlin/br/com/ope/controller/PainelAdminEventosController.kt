package br.com.ope.controller

import br.com.ope.model.Evento
import br.com.ope.repository.CursoRepository
import br.com.ope.repository.DisciplinaRepository
import br.com.ope.repository.EventoRepository
import br.com.ope.repository.TurmaRepository
import br.com.ope.vo.MensagemVO
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.mvc.support.RedirectAttributes
import java.util.*
import javax.validation.Valid

@Controller
@RequestMapping("/painel/admin/eventos")
class PainelAdminEventosController {

    val turmaRepository: TurmaRepository
    val cursoRepository: CursoRepository
    val disciplinaRepository: DisciplinaRepository
    val eventoRepository: EventoRepository

    constructor(turmaRepository: TurmaRepository, cursoRepository: CursoRepository, disciplinaRepository: DisciplinaRepository, eventoRepository: EventoRepository) {
        this.turmaRepository = turmaRepository
        this.cursoRepository = cursoRepository
        this.disciplinaRepository = disciplinaRepository
        this.eventoRepository = eventoRepository
    }

    @GetMapping("/novo")
    fun novo(model : Model, evento: Evento) : String {
        model.addAttribute("evento", evento)
        model.addAttribute("turmas", turmaRepository.findAll())
        model.addAttribute("disciplinas", disciplinaRepository.findAll())
        model.addAttribute("cursos", cursoRepository.findAll())
        return "painel/admin/eventos/novo"
    }

    @PostMapping("/novo")
    fun novoSalvar(model: Model, @Valid evento : Evento, bindingResult: BindingResult, redirectAttributes: RedirectAttributes) : String {

        if (bindingResult.hasErrors()) return this.novo(model, evento)

        eventoRepository.save(evento)
        redirectAttributes.addFlashAttribute("mensagem", MensagemVO("Evento salvo!","Sucesso!", MensagemVO.TipoMensagem.success ))
        return "redirect:/painel/admin"
    }


    @GetMapping("/{id}")
    fun editar(redirectAttributes: RedirectAttributes, model : Model, @PathVariable id : UUID) : String {
        val evento = eventoRepository.findById(id)

        if (!evento.isPresent) return redirectEventoNaoEncontrado(model, redirectAttributes)

        model.addAttribute("evento", evento.get())
        model.addAttribute("turmas", turmaRepository.findAll())
        model.addAttribute("disciplinas", disciplinaRepository.findAll())
        model.addAttribute("cursos", cursoRepository.findAll())
        return "painel/admin/eventos/editar"
    }

    @PostMapping("/{id}")
    fun editarSalvar(@Valid eventoEditado: Evento, bindingResult : BindingResult, redirectAttributes: RedirectAttributes, model : Model, @PathVariable id : UUID) : String {
        val evento = eventoRepository.findById(id)

        if (!evento.isPresent) return redirectEventoNaoEncontrado(model, redirectAttributes)

        if (bindingResult.hasErrors()) return "painel/admin/eventos/editar"

        eventoRepository.save(evento.get().atualizar(eventoEditado))

        redirectAttributes.addFlashAttribute("mensagem", MensagemVO("Evento salvo!","Sucesso!", MensagemVO.TipoMensagem.success ))
        return "redirect:/painel/admin"
    }

    private fun redirectEventoNaoEncontrado(model: Model, redirectAttributes: RedirectAttributes): String {
        redirectAttributes.addFlashAttribute("mensagem", MensagemVO("Evento não encontrado!","Erro!", MensagemVO.TipoMensagem.danger ))
        return "redirect:/painel/admin"
    }


}