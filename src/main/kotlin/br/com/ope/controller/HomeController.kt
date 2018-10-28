package br.com.ope.controller

import br.com.ope.model.Grupo
import br.com.ope.repository.AlunoRepository
import br.com.ope.repository.CursoRepository
import br.com.ope.repository.GrupoRepository
import br.com.ope.vo.MensagemVO
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.servlet.mvc.support.RedirectAttributes

@Controller
class HomeController {

    private val cursoRepository : CursoRepository
    private val grupoRepository : GrupoRepository
    private val alunoRepository : AlunoRepository

    constructor(cursoRepository: CursoRepository, grupoRepository: GrupoRepository, alunoRepository: AlunoRepository) {
        this.cursoRepository = cursoRepository
        this.grupoRepository = grupoRepository
        this.alunoRepository = alunoRepository
    }

    @GetMapping("/")
    fun index(model : Model) : String {

        return "redirect:/grupos"
    }

    @GetMapping("/grupos")
    fun grupos(model : Model) : String {
        model.addAttribute("grupo", Grupo())
        model.addAttribute("cursos", cursoRepository.findAllByOrderByNome())
        return "home/grupos"
    }

    @PostMapping("/grupos")
    fun gruposSalvar(model : Model, redirectAttributes: RedirectAttributes, grupo: Grupo) : String {
        grupo.status = Grupo.Status.AGUARDANDO
        grupo.disciplina = grupo.turma!!.disciplina!!
        grupoRepository.save(grupo)

        for (aluno in grupo.alunos) {
            aluno.turma = grupo.turma
            aluno.grupo = grupo
            alunoRepository.save(aluno)
        }

        redirectAttributes.addFlashAttribute("mensagem", MensagemVO("Aguarde a aprovação do administrador por email, para poder acessar a plataforma!","Grupo salvo!", MensagemVO.TipoMensagem.success ))
        return "redirect:/grupos"
    }

}