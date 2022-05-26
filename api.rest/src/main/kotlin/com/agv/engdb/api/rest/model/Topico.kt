package com.agv.engdb.api.rest.model

import com.agv.engdb.api.rest.enum.StatusTopico
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Topico (
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        var id: Long? = null,

        @Column(name = "titulo")
        var titulo: String,

        @Column(name = "mensagem")
        var mensagem: String,

        @Column(name = "data_criacao")
        var dataCriacao: String = LocalDateTime.now().toString(),

        @ManyToOne
        @JoinTable(name = "curso")
        var curso: Curso,

        @ManyToOne
        @JoinTable(name = "usuario")
        var autor: Usuario,

        @Enumerated(value = EnumType.STRING)
        @Column(name = "status")
        val status: StatusTopico = StatusTopico.NAO_RESPONDIDO,

        @OneToMany(mappedBy = "topico")
        val resposta: List<Resposta> = ArrayList()
)