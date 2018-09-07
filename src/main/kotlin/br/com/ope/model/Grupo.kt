package br.com.ope.model

import java.util.*
import javax.persistence.*

@Entity
class Grupo : AbstractModel {

    var nome : String = ""
    @ManyToOne
    @JoinColumn
    var curso : Curso? = null

    @ManyToMany
    @JoinTable
    var alunos : List<Aluno> = mutableListOf()

    @ManyToMany
    @JoinTable
    var alunosRemovidos : List<Aluno> = mutableListOf()

    constructor() : super()

    constructor(nome: String, curso: Curso?, alunos: List<Aluno>, alunosRemovidos: List<Aluno>) : super() {
        this.nome = nome
        this.curso = curso
        this.alunos = alunos
        this.alunosRemovidos = alunosRemovidos
    }

    constructor(id: UUID?, nome: String, curso: Curso?, alunos: List<Aluno>, alunosRemovidos: List<Aluno>) : super(id) {
        this.nome = nome
        this.curso = curso
        this.alunos = alunos
        this.alunosRemovidos = alunosRemovidos
    }


}