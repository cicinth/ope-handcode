package br.com.ope.model

import com.fasterxml.jackson.annotation.JsonIgnore
import java.time.Year
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Entity
class Turma : AbstractModel {
    @NotBlank
    var letra : String = ""
    @NotNull
    var semestre : Int = 1
    @NotNull
    var ano : Int = Year.now().value
    @ManyToOne
    @JoinColumn
    @NotNull
    @JsonIgnore
    var curso : Curso? = null
    @OneToMany
    @JsonIgnore
    var alunos: List<Aluno> = mutableListOf()
    @Enumerated(EnumType.STRING)
    @NotNull
    var periodo : Periodo? = null

    constructor() : super()

    constructor(id: UUID?) : super(id)
    constructor(letra: String, semestre: Int, ano: Int, curso: Curso?, alunos: List<Aluno>, periodo: Periodo?) : super() {
        this.letra = letra
        this.semestre = semestre
        this.ano = ano
        this.curso = curso
        this.alunos = alunos
        this.periodo = periodo
    }

    fun atualizar(turma: Turma) : Turma {
        this.semestre = turma.semestre
        this.ano = turma.ano
        this.curso = turma.curso
        this.periodo = turma.periodo
        return this
    }

    enum class Periodo(val nome : String) {

        MANHA("Manha"),
        TARDE("Tarde"),
        NOITE("Noite")

    }

}
