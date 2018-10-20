package br.com.ope.model

import java.util.*
import javax.persistence.Entity

@Entity
class Arquivo : AbstractModel{
    var nome : String = ""
    var extensao : String = ""
    var mimeType : String = ""
    var referencia : UUID = UUID.randomUUID()

    constructor() : super()
}