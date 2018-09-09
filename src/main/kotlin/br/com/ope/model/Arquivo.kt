package br.com.ope.model

import javax.persistence.Entity

@Entity
class Arquivo : AbstractModel{
    var nome : String = ""
    var extensao : String = ""
    var mimeType : String = ""

    constructor() : super()
}