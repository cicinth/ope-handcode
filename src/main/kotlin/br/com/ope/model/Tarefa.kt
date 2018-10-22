package br.com.ope.model

import java.util.*
import javax.persistence.Entity
import javax.persistence.OneToMany

@Entity
class Tarefa : Evento {

    @OneToMany(mappedBy = "tarefa")
    var entregas : List<Entrega> = mutableListOf()

    constructor() : super()
    constructor(data: Date, descricao: String, titulo: String, disciplinas: List<Disciplina>, cursos: List<Curso>, turmas: List<Turma>, entregas: List<Entrega>) : super(data, descricao, titulo, disciplinas, cursos, turmas) {
        this.entregas = entregas
    }

    fun atualizar(evento: Tarefa): Tarefa {
        super.atualizar(evento)
        this.entregas = entregas
        return this
    }


}