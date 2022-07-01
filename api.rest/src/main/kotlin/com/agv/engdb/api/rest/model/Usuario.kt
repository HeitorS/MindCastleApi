package com.agv.engdb.api.rest.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "usuario")
data class Usuario (
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        val id: Long? = null,

        @Column(name = "cpf")
        val cpf: String,

        @Column(name = "senha")
        var senha: String,

        @Column(name = "data_criacao")
        val data_criacao: LocalDateTime = LocalDateTime.now(),

        @Column(name = "tentativa_login")
        val tentativa_login: Int,
)
