package br.com.ope.model

import java.util.*
import javax.persistence.*

@Entity
class Tarefa : AbstractModel {
    var dataEntrega : Date? = null
    var dataLiberacao : Date? = null
    var quantidadeEntregas : Int? = null

    @ManyToMany
    @JoinTable
    var anexos : List<Arquivo> = mutableListOf()
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

    constructor(dataEntrega: Date?, dataLiberacao: Date?, quantidadeEntregas: Int?, anexos: List<Arquivo>, descricao: String, titulo: String, disciplina: Disciplina?, curso: Curso?, turmas: List<Turma>) : super() {
        this.dataEntrega = dataEntrega
        this.dataLiberacao = dataLiberacao
        this.quantidadeEntregas = quantidadeEntregas
        this.anexos = anexos
        this.descricao = descricao
        this.titulo = titulo
        this.disciplina = disciplina
        this.curso = curso
        this.turmas = turmas
    }


}