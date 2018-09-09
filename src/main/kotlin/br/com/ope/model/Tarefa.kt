package br.com.ope.model

import java.util.*
import javax.persistence.*

@Entity
class Tarefa : AbstractModel{
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

    constructor() : super()
}