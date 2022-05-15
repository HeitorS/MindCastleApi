package com.agv.engdb.api.rest.dto

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size

data class TopicoForm (
        @field:NotEmpty
        @field:Size(min = 5, max = 100)
        val titulo: String,
        @field:NotEmpty
        val mensagem: String,
        @field:NotEmpty
        val idCurso: Long,
        @field:NotEmpty
        val idAutor: Long
)