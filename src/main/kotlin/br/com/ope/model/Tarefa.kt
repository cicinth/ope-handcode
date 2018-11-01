package br.com.ope.model

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.format.annotation.DateTimeFormat
import java.util.*
import javax.persistence.Entity
import javax.persistence.OneToMany

@Entity
class Tarefa : Evento {

    @OneToMany(mappedBy = "tarefa")
    @JsonIgnore
    var entregas : MutableList<Entrega> = mutableListOf()

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
    var dataEntrega : Date = Date()

    constructor() : super()
    constructor(data: Date, descricao: String, titulo: String, disciplinas: MutableList<Disciplina>, cursos: MutableList<Curso>, turmas: MutableList<Turma>, entregas: MutableList<Entrega>) : super(data, descricao, titulo, disciplinas, cursos, turmas) {
        this.entregas = entregas
    }

    fun atualizar(evento: Tarefa): Tarefa {
        super.atualizar(evento)
        this.entregas = evento.entregas
        return this
    }


}