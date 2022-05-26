package com.agv.engdb.api.rest.model

import javax.persistence.*

@Entity
data class Usuario (
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        val id: Long? = null,

        @Column(name = "nome")
        val nome: String,

        @Column(name = "email")
        val email: String
)
