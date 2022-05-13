package com.agv.engdb.api.rest.service

import com.agv.engdb.api.rest.model.Usuario
import org.springframework.stereotype.Service
import java.util.*

@Service
class UsuaroService (var usuarios: List<Usuario>){

    init {
        val usuario = Usuario(1, "Heitor Victor", "heitor.silva@engdb.com.br")
        usuarios = Arrays.asList(usuario)
    }

    fun buscarPorId(id:Long): Usuario {
        return usuarios.stream().filter({u -> u.id == id}).findFirst().get()
    }

}