package br.com.ope.model

import com.fasterxml.jackson.annotation.JsonIgnore
import java.util.*
import javax.persistence.*

@Entity
class Grupo : AbstractModel {

    var nome : String = ""
    var tema : String = ""
    @ManyToOne
    @JoinColumn
    @JsonIgnore
    var curso : Curso? = null

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    var disciplina : Disciplina? = null

    @ManyToMany
    @JoinTable
    @JsonIgnore
    var disciplinasAnteriores : MutableList<Disciplina> = mutableListOf()

    @OneToMany(mappedBy = "grupo")
    @JsonIgnore
    var alunos : MutableList<Aluno> = mutableListOf()

    @ManyToMany
    @JoinTable
    var alunosRemovidos : MutableList<Aluno> = mutableListOf()

    @Enumerated(EnumType.STRING)
    var status : Status = Status.AGUARDANDO

    var logoHash : UUID? = null

    @ManyToOne
    @JoinColumn
    var turma : Turma? = null

    @OneToMany(mappedBy = "grupo")
    var entregas : MutableList<Entrega> = mutableListOf()

    constructor() : super()

    constructor(id: UUID? = null,
                nome: String,
                curso: Curso?,
                alunos: MutableList<Aluno> = mutableListOf(),
                alunosRemovidos: MutableList<Aluno> = mutableListOf(),
                disciplina: Disciplina? = null,
                turma : Turma,
                tema : String) : super(id) {
        this.nome = nome
        this.curso = curso
        this.alunos = alunos
        this.alunosRemovidos = alunosRemovidos
        this.disciplina = disciplina
        this.turma = turma
        this.tema = tema
    }

    enum class Status(val nome : String, val cor : String) {

        APROVADO("Aprovado", "success"),
        RECUSADO("Recusado", "danger"),
        AGUARDANDO("Aguardando", "warning")

    }

    fun isAprovado() = Status.APROVADO == status

    fun isNotAprovado() = !isAprovado()

    fun isAguardando() = Status.AGUARDANDO == status

}