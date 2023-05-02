package br.com.mind.castle.mindcastle.views

import java.time.LocalDateTime

data class UserView (
    val nome: String,
    val email: String,
    val dataCriacao: LocalDateTime
)