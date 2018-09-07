package br.com.ope.model

import java.util.*
import javax.persistence.Entity
import javax.persistence.ManyToMany

@Entity
class Disciplina : AbstractModel {

    var nome : String = ""
    @ManyToMany
    var cursos: List<Curso> = mutableListOf()

    constructor() : super()

    constructor(id: UUID?) : super(id)

}