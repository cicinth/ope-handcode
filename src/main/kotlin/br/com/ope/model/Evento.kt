package br.com.ope.model

import java.util.*
import javax.persistence.*

@Entity
class Evento : AbstractModel {
    var data : Date? = null
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

    @ManyToOne
    @JoinColumn
    var tarefa : Tarefa? = null

    constructor() : super()

    constructor(data: Date?, descricao: String, titulo: String, disciplina: Disciplina?, curso: Curso?, turmas: List<Turma>, tarefa: Tarefa?) : super() {
        this.data = data
        this.descricao = descricao
        this.titulo = titulo
        this.disciplina = disciplina
        this.curso = curso
        this.turmas = turmas
        this.tarefa = tarefa
    }


}