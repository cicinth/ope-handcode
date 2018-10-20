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
    var curso : Curso? = null

    @ManyToOne
    @JoinColumn
    var disciplina : Disciplina? = null

    @ManyToMany
    @JoinTable
    var disciplinasAnteriores : List<Disciplina> = mutableListOf()

    @ManyToMany
    @JoinTable
    @JsonIgnore
    var alunos : List<Aluno> = mutableListOf()

    @ManyToMany
    @JoinTable
    var alunosRemovidos : List<Aluno> = mutableListOf()

    @Enumerated(EnumType.STRING)
    var status : TipoStatusAprovacaoGrupo = TipoStatusAprovacaoGrupo.AGUARDANDO

    var logoHash : UUID? = null

    @ManyToOne
    @JoinColumn
    var turma : Turma? = null

    @OneToMany(mappedBy = "grupo")
    var entregas : List<Entrega> = mutableListOf()

    constructor() : super()

    constructor(id: UUID? = null,
                nome: String,
                curso: Curso?,
                alunos: List<Aluno> = mutableListOf(),
                alunosRemovidos: List<Aluno> = mutableListOf(),
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

    enum class TipoStatusAprovacaoGrupo(val nome : String, val cor : String) {

        APROVADO("Aprovado", "success"),
        REPROVADO("Reprovado", "danger"),
        AGUARDANDO("Aguardando", "warning")

    }

    fun isAprovado() = TipoStatusAprovacaoGrupo.APROVADO == status

    fun isNotAprovado() = !isAprovado()

    fun isAguardando() = TipoStatusAprovacaoGrupo.AGUARDANDO == status

}