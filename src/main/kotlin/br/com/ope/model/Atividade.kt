package br.com.ope.model

import com.fasterxml.jackson.annotation.JsonIgnore
import java.util.*
import javax.persistence.*

@Entity
class Atividade : AbstractModel {

    var data : Date? = null
    var descricao : String = ""
    var titulo : String = ""
    var dataEntrega : Date? = null
    var dataLiberacao : Date? = null

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    var disciplina : Disciplina? = null

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    var curso : Curso? = null

    @ManyToMany
    @JoinTable
    @JsonIgnore
    var turmas : List<Turma> = mutableListOf()

    constructor() : super()
    constructor(data: Date?, descricao: String, titulo: String, dataEntrega: Date?, dataLiberacao: Date?, disciplina: Disciplina?, curso: Curso?, turmas: List<Turma>) : super() {
        this.data = data
        this.descricao = descricao
        this.titulo = titulo
        this.dataEntrega = dataEntrega
        this.dataLiberacao = dataLiberacao
        this.disciplina = disciplina
        this.curso = curso
        this.turmas = turmas
    }


}