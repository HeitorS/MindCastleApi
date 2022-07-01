package com.agv.engdb.api.rest.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "pessoa")
class Pessoa (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long? = null,

    @Column(name = "nome")
    val nome: String,

    @Column(name = "sobrenome")
    val sobrenome: String,

    @Column(name = "email")
    var email: String,

    @Column(name = "telefone")
    var telefone: String,

    @Column(name = "celular")
    var celular: String,

    @Column(name = "data_nascimento")
    val data_nascimento: LocalDateTime = LocalDateTime.now(),

    @Column(name = "sexo")
    val sexo: String,

    @Column(name = "id_usuario")
    val id_usuario: Long,
)