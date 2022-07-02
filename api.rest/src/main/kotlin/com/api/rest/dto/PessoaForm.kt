package com.api.rest.dto

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size
import java.time.LocalDateTime

data class PessoaForm (
    @field:NotEmpty(message = "Nome não pode estar vazio")
    @field:Size(min = 3, max = 200, message = "Nome não pode ter menos de 3 caracteres ou mais de 200 caracteres")
    val nome: String = "",

    @field:NotEmpty(message = "Sobrenome não pode estar vazio")
    @field:Size(min = 3, max = 200, message = "Sobrenome não pode ter menos de 3 caracteres ou mais de 200 caracteres")
    val sobrenome: String = "",

    @field:NotEmpty(message = "Email não pode estar vazio")
    @field:Size(min = 15, max = 100, message = "Email não pode ter menos de 15 caracteres ou mais de 100 caracteres")
    val email: String = "",

    @field:NotEmpty(message = "Confirmação de Senha não pode estar vazio")
    @field:Size(min = 14, max = 15, message = "Telefone não pode ter menos de 14 caracteres")
    val telefone: String = "",

    @field:NotEmpty(message = "Celular de Senha não pode estar vazio")
    @field:Size(min = 15, max = 16, message = "Celular não pode ter menos de 14 caracteres")
    val celular: String = "",

    @field:NotEmpty(message = "Data de Nascimento não pode estar vazia")
    val data_nascimento: String = "01/01/1900",

    @field:NotEmpty(message = "Sexo não pode estar vazio")
    @field:Size(min = 1, max = 1, message = "Sexo só pode conter um caracter")
    val sexo: String = "",

    val id_usuario: Long = 0,
)