package com.api.rest.exception

class NotFoundException (): RuntimeException() {
    fun message(): String {
        return "A busca não retornou nenhum valor"
    }
}