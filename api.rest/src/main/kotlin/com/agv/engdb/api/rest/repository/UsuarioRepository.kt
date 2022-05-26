package com.agv.engdb.api.rest.repository

import com.agv.engdb.api.rest.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository

interface UsuarioRepository:JpaRepository<Usuario, Long> {
}