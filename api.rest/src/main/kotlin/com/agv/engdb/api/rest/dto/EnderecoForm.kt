package com.agv.engdb.api.rest.dto

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size

data class EnderecoForm (
    @field:NotEmpty(message = "Cep não pode estar vazio")
    @field:Size(min = 8, max = 9, message = "Cep não pode ter menos de 8 caracteres ou mais de 9 caracteres")
    val cep: String,

    val logradouro: String,

    val bairro: String,

    val estado: String,

    val cidade: String,

    val numero: Int,

    val complemento: String
)