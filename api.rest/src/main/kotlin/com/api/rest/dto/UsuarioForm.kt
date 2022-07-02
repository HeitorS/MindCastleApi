package com.api.rest.dto

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size

data class UsuarioForm (
    @field:NotEmpty(message = "CPF não pode estar vazio")
    @field:Size(min = 11, max = 14, message = "CPF não pode ter menos de 11 caracteres ou mais de 14 caracteres")
    val cpf: String,

    @field:NotEmpty(message = "Senha não pode estar vazio")
    @field:Size(min = 8, max = 20, message = "Senha não pode ter menos de 8 caracteres ou mais de 20 caracteres")
    val senha: String,

    @field:NotEmpty(message = "Confirmação de Senha não pode estar vazio")
    @field:Size(min = 8, max = 20, message = "Confirmação de Senha não pode ter menos de 8 caracteres ou mais de 20 caracteres")
    val confSenha: String

)