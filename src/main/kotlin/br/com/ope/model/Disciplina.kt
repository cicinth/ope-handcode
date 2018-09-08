package br.com.ope.model

import java.util.*
import javax.persistence.Entity
import javax.persistence.ManyToMany
import javax.persistence.OneToMany

@Entity
class Disciplina : AbstractModel {

    var nome : String = ""
    var sigla  : String = ""
    var semestre : Int = 1
    @ManyToMany
    var cursos: List<Curso> = mutableListOf()
    @OneToMany(mappedBy = "disciplina")
    var grupos: List<Grupo> = mutableListOf()
    @ManyToMany(mappedBy = "disciplinasAnteriores")
    var gruposAnteriores: List<Grupo> = mutableListOf()

    constructor() : super()

    constructor(id: UUID?) : super(id)
    constructor(nome: String, sigla: String) : super() {
        this.nome = nome
        this.sigla = sigla
    }


}