package com.agv.engdb.api.rest.exception

import org.hibernate.exception.ConstraintViolationException

class EmailCadastradoException(): ConstraintViolationException("message", null, null) {
    fun message(): String {
        return "Esse cpf já foi utilizado em uma outra conta!"
    }
}