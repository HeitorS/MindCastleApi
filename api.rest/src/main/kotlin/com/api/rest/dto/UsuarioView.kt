package com.api.rest.dto

import java.time.LocalDateTime

data class UsuarioView (
    val id: Long?,
    val cpf: String = "",
    val senha: String = "",
    val data_criacao: LocalDateTime = LocalDateTime.now(),
    val tentativa_login: Int = 0
)