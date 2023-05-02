package br.com.mind.castle.mindcastle.views

import java.time.LocalDateTime

data class LoginView (
    val nome: String,
    val email: String,
    val dataCriacao: LocalDateTime
)