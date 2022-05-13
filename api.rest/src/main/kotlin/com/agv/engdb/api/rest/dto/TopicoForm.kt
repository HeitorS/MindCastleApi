package com.agv.engdb.api.rest.dto

data class TopicoForm (
        val titulo: String,
        val mensagem: String,
        val idCurso: Long,
        val idAutor: Long
)