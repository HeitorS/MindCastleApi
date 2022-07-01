package com.agv.engdb.api.rest.repository

import org.springframework.data.jpa.repository.JpaRepository
import com.agv.engdb.api.rest.model.Endereco

interface EnderecoRepository: JpaRepository<Endereco, Long> {
    fun getByCep(cep: String): Endereco

    fun deleteByCep(cep: String)
}