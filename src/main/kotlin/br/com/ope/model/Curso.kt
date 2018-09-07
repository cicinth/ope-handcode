package br.com.ope.model

import java.util.*
import javax.persistence.Entity
import javax.persistence.JoinTable
import javax.persistence.ManyToMany
import javax.persistence.OneToMany

@Entity
class Curso : AbstractModel {

    var nome : String = ""
    var sigla : String = ""
    var semestres : Int = 0
    @ManyToMany
    @JoinTable
    var disciplinas: List<Disciplina> = mutableListOf()

    @OneToMany
    var grupos: List<Grupo> = mutableListOf()

    constructor() : super()

    constructor(id: UUID?) : super(id)
    constructor(nome: String, sigla: String, semestres: Int) : super() {
        this.nome = nome
        this.sigla = sigla
        this.semestres = semestres
    }


}