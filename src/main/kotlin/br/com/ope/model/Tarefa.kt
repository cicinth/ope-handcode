package br.com.ope.model

import java.util.*
import javax.persistence.Entity
import javax.persistence.OneToMany

@Entity
class Tarefa : Evento {
    var dataEntrega : Date? = null
    var dataLiberacao : Date? = null

    @OneToMany(mappedBy = "tarefa")
    var entregas : List<Entrega> = mutableListOf()

    constructor() : super()

    constructor(descricao: String, titulo: String, disciplina: Disciplina?, curso: Curso?, turmas: List<Turma>, dataEntrega: Date?, dataLiberacao: Date?) : super(descricao, titulo, disciplina, curso, turmas) {
        this.dataEntrega = dataEntrega
        this.dataLiberacao = dataLiberacao
    }

}