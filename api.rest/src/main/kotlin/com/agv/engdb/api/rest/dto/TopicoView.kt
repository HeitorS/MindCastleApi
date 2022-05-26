package com.agv.engdb.api.rest.dto

import com.agv.engdb.api.rest.enum.StatusTopico
import java.time.LocalDateTime

data class TopicoView (
        val id: Long?,
        val titulo: String,
        val mensagem: String,
        val status: StatusTopico,
        val dataCriacao: String
)