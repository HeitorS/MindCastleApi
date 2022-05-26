package com.agv.engdb.api.rest.service

import com.agv.engdb.api.rest.repository.CursoRepository
import org.springframework.stereotype.Service
import com.agv.engdb.api.rest.model.Curso

@Service
class CursoService (private val repository: CursoRepository){

    fun buscarPorId(id:Long): Curso {
        return repository.getById(id)
    }

}
