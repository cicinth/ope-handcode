package br.com.ope.model

import java.util.*
import javax.persistence.Entity
import javax.persistence.ManyToMany

@Entity
class Disciplina : AbstractModel {

    var nome : String = ""
    var sigla  : String = ""
    var semestre : Int = 1

    @ManyToMany
    var cursos: List<Curso> = mutableListOf()

    constructor() : super()

    constructor(id: UUID?) : super(id)
    constructor(nome: String, sigla: String) : super() {
        this.nome = nome
        this.sigla = sigla
    }


}