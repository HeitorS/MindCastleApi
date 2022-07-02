package com.api.rest.model

import javax.persistence.EmbeddedId
import javax.persistence.Entity
import javax.persistence.Table


@Entity
@Table(name = "endereco_pessoa")
class EndPes (
    @EmbeddedId
    var fk: EndPesEmb
)