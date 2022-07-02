package com.api.rest.repository

import org.springframework.data.jpa.repository.JpaRepository
import com.api.rest.model.Pessoa
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface PessoaRepository: JpaRepository<Pessoa,Long> {
    @Query("select * from api_rest.pessoa where id_usuario = :id_us",
        nativeQuery = true)
    fun findByIdUsuario(@Param("id_us") id_usuario: Long): Pessoa

    fun findByEmail(email: String?): Pessoa
}