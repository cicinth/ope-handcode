package br.com.ope.model

import javax.persistence.*

@Entity
open class Evento : AbstractModel {
    var descricao : String = ""
    var titulo : String = ""

    @ManyToOne
    @JoinColumn
    var disciplina : Disciplina? = null

    @ManyToOne
    @JoinColumn
    var curso : Curso? = null

    @ManyToMany
    @JoinTable
    var turmas : List<Turma> = mutableListOf()

    constructor() : super()
    constructor(descricao: String, titulo: String, disciplina: Disciplina?, curso: Curso?, turmas: List<Turma>) : super() {
        this.descricao = descricao
        this.titulo = titulo
        this.disciplina = disciplina
        this.curso = curso
        this.turmas = turmas
    }


}