package com.agv.engdb.api.rest.service

import com.agv.engdb.api.rest.repository.TopicoRepository
import com.agv.engdb.api.rest.exception.NotFoundException
import com.agv.engdb.api.rest.mapper.AltTopicoFormMapper
import com.agv.engdb.api.rest.mapper.TopicoFormMapper
import com.agv.engdb.api.rest.mapper.TopicoViewMapper
import com.agv.engdb.api.rest.dto.AltTopicoForm
import org.springframework.stereotype.Service
import com.agv.engdb.api.rest.dto.TopicoForm
import com.agv.engdb.api.rest.dto.TopicoView
import java.time.LocalDateTime
import java.util.stream.Collectors

@Service
class TopicoService (private val repository: TopicoRepository,
                     private val topicoViewMapper: TopicoViewMapper,
                     private val topicoFormMapper: TopicoFormMapper
) {

    fun listar(): List<TopicoView> {
        return repository.findAll().stream().map { t ->
            topicoViewMapper.map(t)
        }.collect(Collectors.toList())
    }

    fun buscaPorId(id: Long): TopicoView {
        val topico = repository.findById(id)
            .orElseThrow{NotFoundException()}
        return topicoViewMapper.map(topico)
    }

    fun cadastrar(dto: TopicoForm): TopicoView {
        var topico = topicoFormMapper.map(dto);
        repository.insertTopico(dto.titulo, dto.mensagem, LocalDateTime.now().toString(),dto.idCurso, dto.idAutor, topico.status.name)
        return topicoViewMapper.map(topico)
    }

    fun atualizar(form: AltTopicoForm): TopicoView {
        var topico = repository.findById(form.id)
            .orElseThrow{NotFoundException()}
        topico.titulo = form.titulo
        topico.mensagem = form.mensagem
        return topicoViewMapper.map(topico)
    }

    fun deletar(id: Long) {
        repository.deleteById(id)
    }
}