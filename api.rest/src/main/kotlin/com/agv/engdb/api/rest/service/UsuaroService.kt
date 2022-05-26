package com.agv.engdb.api.rest.service

import com.agv.engdb.api.rest.repository.UsuarioRepository
import org.springframework.stereotype.Service
import com.agv.engdb.api.rest.model.Usuario

@Service
class UsuaroService (private val repository: UsuarioRepository){

    fun buscarPorId(id:Long): Usuario {
        return repository.getById(id)
    }

}