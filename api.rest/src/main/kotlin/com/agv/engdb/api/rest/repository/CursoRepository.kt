package com.agv.engdb.api.rest.repository

import com.agv.engdb.api.rest.model.Curso
import org.springframework.data.jpa.repository.JpaRepository

interface CursoRepository: JpaRepository<Curso, Long> {

}