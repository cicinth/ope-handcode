package br.com.ope.validators

import br.com.ope.model.Aluno
import br.com.ope.repository.AlunoRepository
import br.com.ope.repository.GrupoRepository
import org.springframework.stereotype.Component
import org.springframework.validation.Errors
import org.springframework.validation.Validator

@Component
class AlunoNovoValidator : Validator {

    val alunoRepository: AlunoRepository
    val grupoRepository: GrupoRepository

    constructor(alunoRepository: AlunoRepository, grupoRepository: GrupoRepository) {
        this.alunoRepository = alunoRepository
        this.grupoRepository = grupoRepository
    }

    override fun validate(target: Any?, errors: Errors) {

        val alunoValidado = target!! as Aluno

        if (alunoValidado.ra != null) {
            val ra = alunoValidado.ra!!
            val alunoEncontrado = alunoRepository.findOneByRa(ra) //TODO JOIN GRUPO
            if (alunoEncontrado.isPresent && alunoEncontrado.get().grupo != null) {
                errors.rejectValue("ra", "exists", "Aluno do ra $ra está ativo em outro grupo.")
            }
        }
    }

    override fun supports(clazz: Class<*>) = Aluno::class.java.isAssignableFrom(clazz)

    companion object {
        const val REQUIRED = "required"
    }
}