package com.agv.engdb.api.rest.dto

import java.time.LocalDateTime

data class UsuarioView (
    val cpf: String = "",
    val senha: String = "",
    val data_criacao: LocalDateTime = LocalDateTime.now(),
    val tentativa_login: Int = 0
)