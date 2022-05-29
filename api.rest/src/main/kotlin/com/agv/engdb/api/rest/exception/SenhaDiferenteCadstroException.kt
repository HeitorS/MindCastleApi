package com.agv.engdb.api.rest.exception

class SenhaDiferenteCadstroException(): Exception() {
    fun message(): String {
        return "As senhas são diferente. Por favor digite novamente!"
    }
}