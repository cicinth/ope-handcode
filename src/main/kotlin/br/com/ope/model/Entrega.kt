package br.com.ope.model

import com.fasterxml.jackson.annotation.JsonIgnore
import java.util.*
import javax.persistence.*

@Entity
class Entrega : AbstractModel {

    var dataEntrega : Date? = null
    var status : Status = Status.PENDENTE

    @ManyToOne
    @JoinColumn
    var tarefa : Tarefa? = null

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    var grupo : Grupo? = null

    @ManyToMany
    @JoinTable
    var arquivos: List<Arquivo> = mutableListOf()

    constructor() : super()
    constructor(dataEntrega: Date?, situacaoEntrega: Status, tarefa: Tarefa?, grupo: Grupo?, arquivos: List<Arquivo>) : super() {
        this.dataEntrega = dataEntrega
        this.status = situacaoEntrega
        this.tarefa = tarefa
        this.grupo = grupo
        this.arquivos = arquivos
    }


    enum class Status(val nome : String) {

        PENDENTE("Pendente"),
        ENTREGUE("Entregue")

    }


}