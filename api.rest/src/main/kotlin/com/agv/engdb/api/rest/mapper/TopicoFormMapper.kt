package com.agv.engdb.api.rest.mapper

import com.agv.engdb.api.rest.dto.TopicoForm
import com.agv.engdb.api.rest.model.Topico
import com.agv.engdb.api.rest.service.CursoService
import com.agv.engdb.api.rest.service.UsuaroService

class TopicoFormMapper(private val cursoService: CursoService,
                       private val usuarioService: UsuaroService): Mapper<TopicoForm, Topico> {
    override fun map(t: TopicoForm): Topico {
        return Topico(
            titulo = t.titulo,
            mensagem = t.mensagem,
            curso = cursoService.buscarPorId(t.idCurso),
            autor = usuarioService.buscarPorId(t.idAutor)
        )
    }
}