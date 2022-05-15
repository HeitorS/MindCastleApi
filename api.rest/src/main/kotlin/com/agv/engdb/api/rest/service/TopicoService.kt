package com.agv.engdb.api.rest.service

import com.agv.engdb.api.rest.dto.AltTopicoForm
import com.agv.engdb.api.rest.dto.TopicoForm
import com.agv.engdb.api.rest.dto.TopicoView
import com.agv.engdb.api.rest.exception.NotFoundException
import com.agv.engdb.api.rest.mapper.AltTopicoFormMapper
import com.agv.engdb.api.rest.mapper.TopicoFormMapper
import com.agv.engdb.api.rest.mapper.TopicoViewMapper
import com.agv.engdb.api.rest.model.Topico
import org.springframework.stereotype.Service
import kotlin.collections.ArrayList
import java.util.stream.Collectors

@Service
class TopicoService (private var topicos: ArrayList<Topico> = ArrayList(),
                     private val topicoViewMapper: TopicoViewMapper,
                     private val topicoFormMapper: TopicoFormMapper,
                     private val altTopicoFormMapper: AltTopicoFormMapper
) {

    fun listar(): List<TopicoView> {
        return topicos.stream().map { t ->
            topicoViewMapper.map(t)
        }.collect(Collectors.toList())
    }

    fun buscaTopicoPorId(id: Long): Topico {
        return topicos.stream().filter { t ->
            t.id == id
        }.findFirst().orElseThrow{NotFoundException()}
    }

    fun buscaPorId(id: Long): TopicoView {
        val topico = buscaTopicoPorId(id)
        return topicoViewMapper.map(topico)
    }

    fun cadastrar(dto: TopicoForm): TopicoView {
        var t = topicoFormMapper.map(dto);
        t.id = (topicos.size + 1).toLong()
        topicos += t
        return topicoViewMapper.map(t)
    }

    fun atualizar(form: AltTopicoForm): TopicoView {
        var topico = buscaTopicoPorId(form.id)
        topicos.remove(topico)
        val t = altTopicoFormMapper.map(form)
        topico = Topico (
            id = t.id,
            titulo = t.titulo,
            mensagem = t.mensagem,
            curso = topico.curso,
            autor = topico.autor,
            dataCriacao = topico.dataCriacao
        )
        topicos.add(topico)
        return topicoViewMapper.map(topico)
    }

    fun deletar(id: Long) {
        val topico = buscaTopicoPorId(id)
        topicos.remove(topico)
    }
}