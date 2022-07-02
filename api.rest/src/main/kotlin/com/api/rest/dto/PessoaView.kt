package com.api.rest.dto

import java.time.LocalDateTime

data class PessoaView (
    val nome: String = "",
    val sobrenome: String = "",
    val email: String = "",
    val telefone: String = "",
    val celular: String = "",
    val data_nascimento: LocalDateTime = LocalDateTime.now(),
    val sexo: String = "",
    val id_usuario: Long = 0
)