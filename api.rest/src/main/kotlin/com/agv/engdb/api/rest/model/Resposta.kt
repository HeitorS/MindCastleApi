package com.agv.engdb.api.rest.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinTable
import javax.persistence.ManyToOne

@Entity
data class Resposta (
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        val id: Long? = null,

        @Column(name = "mensagem")
        val mensagem: String,

        @Column(name = "data_criacao")
        val dataCriacao: String,

        @ManyToOne
        @JoinTable(name = "usuario")
        val autor: Usuario,

        @ManyToOne
        @JoinTable(name = "topico")
        val topico: Topico,

        @Column(name = "solucao")
        val solucao: Boolean
)

