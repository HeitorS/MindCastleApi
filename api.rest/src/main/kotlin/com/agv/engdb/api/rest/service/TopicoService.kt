package com.agv.engdb.api.rest.service

import com.agv.engdb.api.rest.dto.TopicoForm
import com.agv.engdb.api.rest.dto.TopicoView
import com.agv.engdb.api.rest.mapper.TopicoFormMapper
import com.agv.engdb.api.rest.mapper.TopicoViewMapper
import com.agv.engdb.api.rest.model.Topico
import org.springframework.stereotype.Service
import kotlin.collections.ArrayList
import java.util.stream.Collectors

@Service
class TopicoService (private var topicos: List<Topico> = ArrayList(),
                     private val topicoViewaMapper: TopicoViewMapper,
                     private val topicoFormMapper: TopicoFormMapper) {

    fun listar(): List<TopicoView> {
        val list = topicos.stream().map { t ->
            topicoViewaMapper.map(t)
         }.collect(Collectors.toList())
        return list
    }

    fun buscaPorId(id: Long): TopicoView {
        val topico = topicos.stream().filter { t ->
            t.id == id
        }.findFirst().get()

        return topicoViewaMapper.map(topico)
    }

    fun cadastrar(dto: TopicoForm) {
        topicos += topicoFormMapper.map(dto)
    }
}