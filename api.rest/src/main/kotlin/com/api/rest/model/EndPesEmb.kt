package com.api.rest.model

import java.io.Serializable
import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
data class EndPesEmb (
    @Column(name = "id_pessoa")
    val id_pessoa: Long,

    @Column(name = "id_endereco")
    val id_endereco: Long
): Serializable