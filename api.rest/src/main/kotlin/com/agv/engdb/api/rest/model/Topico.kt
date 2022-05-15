package com.agv.engdb.api.rest.model

import com.agv.engdb.api.rest.enum.StatusTopico
import java.time.LocalDateTime

data class Topico (
        var id: Long? = null,
        val titulo: String,
        val mensagem: String,
        var dataCriacao: LocalDateTime = LocalDateTime.now(),
        var curso: Curso,
        var autor: Usuario,
        val status: StatusTopico = StatusTopico.NAO_RESPONDIDO,
        val resposta: List<Resposta> = ArrayList()
)