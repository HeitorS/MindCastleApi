package com.agv.engdb.api.rest.repository

import org.springframework.data.jpa.repository.JpaRepository
import com.agv.engdb.api.rest.model.Pessoa
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface PessoaRepository: JpaRepository<Pessoa,Long> {
    @Query("SELECT p FROM pessoa p WHERE p.id_usuario = :id_us",
        nativeQuery = true)
    fun findByIdUsuario(@Param("id_us") id_usuario: Long): Pessoa
}