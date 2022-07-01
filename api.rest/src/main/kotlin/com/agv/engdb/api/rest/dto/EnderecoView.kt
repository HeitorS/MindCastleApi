package com.agv.engdb.api.rest.dto

data class EnderecoView (
    val cep: String = "",
    val logradouro: String = "",
    val bairro: String = "",
    val estado: String = "",
    val cidade: String = "",
    val numero: Int = 0,
    val complemento: String = ""
)