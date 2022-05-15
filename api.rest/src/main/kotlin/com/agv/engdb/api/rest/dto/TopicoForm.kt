package com.agv.engdb.api.rest.dto

import org.springframework.lang.NonNull
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size

data class TopicoForm (
        @field:NotEmpty(message = "Título não pode ser vazio")
        @field:Size(min = 5, max = 100, message = "Título tem que conter entre 5 e 100 caracteres")
        val titulo: String,
        @field:NotEmpty(message = "Mensagem não pode ser vazia")
        val mensagem: String,
        @field:NonNull
        val idCurso: Long,
        @field:NonNull
        val idAutor: Long
)