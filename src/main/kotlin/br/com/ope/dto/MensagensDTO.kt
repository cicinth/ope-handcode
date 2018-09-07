package br.com.ope.dto

import java.io.Serializable

class mensagemDTO : Serializable {

    val conteudo : String
    val titulo : String
    val tipo : TipoMensagem
    val linkNome : String
    val linkURL : String

    constructor(conteudo: String = "", titulo: String  = "", tipo: TipoMensagem = TipoMensagem.info, linkNome: String = "", linkURL: String = "") {
        this.conteudo = conteudo
        this.titulo = titulo
        this.tipo = tipo
        this.linkNome = linkNome
        this.linkURL = linkURL
    }

    enum class TipoMensagem {
        success,
        info,
        warning,
        danger
    }

}