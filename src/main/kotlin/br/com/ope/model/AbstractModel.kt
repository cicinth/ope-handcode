package br.com.ope.model

import org.hibernate.annotations.GenericGenerator
import java.util.*
import javax.persistence.*

@MappedSuperclass
abstract class AbstractModel {

    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Id
    var id: UUID? = null

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    var dataCriacao : Date = Date()

    var dataExclusao : Date? = null

    constructor()

    constructor(id: UUID?) {
        this.id = id
    }

}