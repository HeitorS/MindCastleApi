package com.agv.engdb.api.rest.repository

import com.agv.engdb.api.rest.model.Topico
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface TopicoRepository: JpaRepository<Topico, Long> {

    @Query("INSERT INTO topico (titulo, mensagem, data_criacao, curso, autor, status) VALUES (:titulo, :mensagem, :data_criacao, :curso, :autor, :status)")
    fun insertTopico(
        @Param("titulo") titulo: String,
        @Param("mensagem") mensagem: String,
        @Param("data_criacao") data_criacao: String,
        @Param("curso") curso: Long,
        @Param("autor") autor: Long,
        @Param("status") status: String
    ): Long

}