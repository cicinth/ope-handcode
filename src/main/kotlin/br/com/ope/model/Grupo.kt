package br.com.ope.model

import java.util.*
import javax.persistence.*

@Entity
class Grupo : AbstractModel {

    var nome : String = ""
    @ManyToOne
    @JoinColumn
    var curso : Curso? = null

    @ManyToOne
    @JoinColumn
    var disciplina : Disciplina? = null

    @ManyToMany
    @JoinTable
    var disciplinasAnteriores : List<Disciplina> = mutableListOf()

    @ManyToMany
    @JoinTable
    var alunos : List<Aluno> = mutableListOf()

    @ManyToMany
    @JoinTable
    var alunosRemovidos : List<Aluno> = mutableListOf()

    @Enumerated(EnumType.STRING)
    var status : TipoStatusAprovacaoGrupo = TipoStatusAprovacaoGrupo.AGUARDANDO

    @Transient
    var turma : Turma? = null

    constructor() : super()

    constructor(nome: String, curso: Curso?, alunos: List<Aluno>, alunosRemovidos: List<Aluno>) : super() {
        this.nome = nome
        this.curso = curso
        this.alunos = alunos
        this.alunosRemovidos = alunosRemovidos
    }

    constructor(id: UUID? = null,
                nome: String,
                curso: Curso?,
                alunos: List<Aluno> = mutableListOf(),
                alunosRemovidos: List<Aluno> = mutableListOf(),
                disciplina: Disciplina? = null) : super(id) {
        this.nome = nome
        this.curso = curso
        this.alunos = alunos
        this.alunosRemovidos = alunosRemovidos
        this.disciplina = disciplina
    }

    enum class TipoStatusAprovacaoGrupo(val nome : String, val cor : String) {

        APROVADO("Aprovado", "success"),
        REPROVADO("Reprovado", "danger"),
        AGUARDANDO("Aguardando aprovação", "warning")

    }

}