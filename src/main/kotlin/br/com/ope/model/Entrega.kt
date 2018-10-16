package br.com.ope.model

import com.fasterxml.jackson.annotation.JsonIgnore
import java.util.*
import javax.persistence.*

@Entity
class Entrega : AbstractModel {

    var data : Date? = null
    var descricao : String = ""
    var titulo : String = ""
    var dataEntrega : Date? = null
    var dataLiberacao : Date? = null
    var situacaoEntega : Status = Status.PENDENTE

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
    constructor(data: Date?, descricao: String, titulo: String, dataEntrega: Date?, dataLiberacao: Date?, situacaoEntega: Status, disciplina: Disciplina?, curso: Curso?, turmas: List<Turma>) : super() {
        this.data = data
        this.descricao = descricao
        this.titulo = titulo
        this.dataEntrega = dataEntrega
        this.dataLiberacao = dataLiberacao
        this.situacaoEntega = situacaoEntega
        this.disciplina = disciplina
        this.curso = curso
        this.turmas = turmas
    }


    enum class Status(val nome : String) {

        PENDENTE("Pendente"),
        ENTREGUE("Entregue")

    }


}