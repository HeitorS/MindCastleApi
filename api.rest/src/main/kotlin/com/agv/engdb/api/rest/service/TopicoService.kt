package com.agv.engdb.api.rest.service

import com.agv.engdb.api.rest.dto.TopicoForm
import com.agv.engdb.api.rest.dto.TopicoView
import com.agv.engdb.api.rest.model.Topico
import org.springframework.stereotype.Service
import kotlin.collections.ArrayList
import java.util.stream.Collectors

@Service
class TopicoService (private var topicos: List<Topico> = ArrayList(),
                     private val cursoService: CursoService,
                     private val usuarioService: UsuaroService) {

    fun listar(): List<TopicoView> {
        val list = topicos.stream().map { t -> TopicoView(
            id = t.id,
            titulo = t.titulo,
            mensagem = t.mensagem,
            status = t.status,
            dataCriacao = t.dataCriacao
        )}.collect(Collectors.toList())
        println(topicos)
        println(list)
        return list
    }

    fun buscaPorId(id: Long): TopicoView {
        val topico = topicos.stream().filter { t ->
            t.id == id
        }.findFirst().get()

        return TopicoView(
            id = topico.id,
            titulo = topico.titulo,
            mensagem = topico.mensagem,
            status = topico.status,
            dataCriacao = topico.dataCriacao
        )
    }

    fun cadastrar(dto: TopicoForm) {
        val topico = Topico(
            id = topicos.size.toLong() + 1,
            titulo = dto.titulo,
            mensagem = dto.mensagem,
            curso = cursoService.buscarPorId(dto.idCurso),
            autor = usuarioService.buscarPorId(dto.idAutor)
        )
        topicos += topico
    }
}