package com.api.rest.model

import javax.persistence.*

@Entity
@Table(name = "endereco")
class Endereco (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long? = null,

    @Column(name = "cep")
    val cep: String,

    @Column(name = "logradouro")
    val logradouro: String,

    @Column(name = "bairro")
    var bairro: String,

    @Column(name = "estado")
    var estado: String,

    @Column(name = "cidade")
    var cidade: String,

    @Column(name = "numero")
    val numero: Int,

    @Column(name = "complemento")
    val complemento: String
)