package br.com.ope.model

import br.com.ope.enumx.Role
import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.ManyToMany
import javax.persistence.ManyToOne

@Entity
class Aluno : Usuario {

    var ra : Long = 0

    @ManyToMany(mappedBy = "alunos")
    var grupos : List<Grupo> = mutableListOf()

    @ManyToOne
    @JoinColumn
    var turma: Turma? = null

    @ManyToMany(mappedBy = "alunosRemovidos")
    var gruposRemovidos : List<Grupo> = mutableListOf()

    constructor() : super()

    constructor(nome: String = "",
                email: String = "",
                ativo: Boolean = false,
                senha: String = "",
                permissoes: MutableSet<Role> = mutableSetOf(),
                ra: Long = 0,
                grupos: List<Grupo> = mutableListOf(),
                gruposRemovidos: List<Grupo> = mutableListOf(), turma : Turma) : super(nome, email, ativo, senha, permissoes) {
        this.ra = ra
        this.grupos = grupos
        this.gruposRemovidos = gruposRemovidos
        this.turma = turma
    }


}