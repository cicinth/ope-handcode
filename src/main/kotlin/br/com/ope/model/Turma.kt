package br.com.ope.model

import java.time.Year
import java.time.temporal.TemporalField
import java.util.*
import javax.persistence.*

@Entity
class Turma : AbstractModel {

    var letra : String = ""
    var semestre : Int = 1
    var ano : Int = Year.now().value
    @ManyToOne
    @JoinColumn
    var curso : Curso? = null
    @OneToMany
    var alunos: List<Aluno> = mutableListOf()
    @Enumerated(EnumType.STRING)
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


    enum class Periodo(val nome : String) {

        MANHA("Manha"),
        TARDE("Tarde"),
        NOITE("Noite")

    }

}