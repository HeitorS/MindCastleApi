package com.agv.engdb.api.rest.dto

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size

data class UsuarioForm (
    @field:NotEmpty(message = "Nome não pode estar vazio")
    @field:Size(min = 3, max = 250, message = "Nome não pode ter menos de 3 caracteres ou mais de 250 caracteres")
    val nome: String,
    @field:NotEmpty(message = "CPF não pode estar vazio")
    @field:Size(min = 11, max = 14, message = "CPF não pode ter menos de 11 caracteres ou mais de 14 caracteres")
    val cpf: String,
    @field:NotEmpty(message = "Senha não pode estar vazio")
    @field:Size(min = 8, max = 20, message = "Senha não pode ter menos de 8 caracteres ou mais de 20 caracteres")
    val senha: String,
    @field:NotEmpty(message = "Confirmação de Senha não pode estar vazio")
    @field:Size(min = 8, max = 20, message = "Confirmação de Senha não pode ter menos de 8 caracteres ou mais de 20 caracteres")
    val confSenha: String,
    @field:NotEmpty(message = "E-mail não pode estar vazio")
    @field:Size(min = 5, max = 150, message = "E-mail não pode ter menos de 5 caracteres ou mais de 150 caracteres")
    val email: String
)