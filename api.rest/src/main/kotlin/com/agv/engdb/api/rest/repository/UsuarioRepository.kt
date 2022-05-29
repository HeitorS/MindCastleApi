package com.agv.engdb.api.rest.repository

import org.springframework.data.jpa.repository.JpaRepository
import com.agv.engdb.api.rest.model.Usuario

interface UsuarioRepository:JpaRepository<Usuario, Long> {
    fun findByCpf(cpf: String):  Usuario

    fun deleteByCpf(cpf: String)
}