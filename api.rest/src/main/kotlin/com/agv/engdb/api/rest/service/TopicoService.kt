package com.agv.engdb.api.rest.service

import com.agv.engdb.api.rest.dto.TopicoDto
import com.agv.engdb.api.rest.dto.TopicoView
import com.agv.engdb.api.rest.model.Topico
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestBody
import java.util.stream.Collectors
import kotlin.collections.ArrayList

@Service
class TopicoService (private var topicos: List<Topico> = ArrayList(), private val cursoService: CursoService, private val usuarioService: UsuaroService) {

    fun listar(): List<TopicoView> {
        return topicos.map { t -> TopicoView(
            id = t.id,
            titulo = t.titulo,
            mensagem = t.mensagem,
            status = t.status,
            dataCriacao = t.dataCriacao
        )}
    }

    fun buscaPorId(id: Long): Topico {
        return topicos.stream().filter({ t -> t.id == id}).findFirst().get()
    }

    fun cadastrar(dto: TopicoDto) {
        topicos.plus(
            Topico(
                id = topicos.size.toLong() + 1,
                titulo = dto.titulo,
                mensagem = dto.mensagem,
                curso = cursoService.buscarPorId(dto.idCurso),
                autor = usuarioService.buscarPorId(dto.idAutor)
        ));
    }
}