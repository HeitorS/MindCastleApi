package com.agv.engdb.api.rest.dto

import java.time.LocalDateTime

data class UsuarioView (
    val nome: String = "",
    val cpf: String = "",
    val senha: String = "",
    val email: String = "",
    val data_criacao: LocalDateTime = LocalDateTime.now(),
    val tentativa_login: Int = 0
)