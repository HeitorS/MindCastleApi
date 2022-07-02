package com.api.rest.repository

import org.springframework.data.jpa.repository.JpaRepository
import com.api.rest.model.Endereco

interface EnderecoRepository: JpaRepository<Endereco, Long> {
    fun getByCep(cep: String): Endereco

    fun deleteByCep(cep: String)
}