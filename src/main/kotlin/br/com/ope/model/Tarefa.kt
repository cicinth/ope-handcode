package br.com.ope.model

import java.util.*
import javax.persistence.Entity

@Entity
class Tarefa : AbstractModel{
    var dataEntrega : Date? = null
    var dataLiberacao : Date? = null
    var quantidadeEntregas : Int? = null
    var anexos : Int? = null
    var descricao : String = ""
    var titulo : String = ""

    constructor() : super()


}