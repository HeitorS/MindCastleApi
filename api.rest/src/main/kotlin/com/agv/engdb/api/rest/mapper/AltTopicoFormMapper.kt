package com.agv.engdb.api.rest.mapper

import com.agv.engdb.api.rest.dto.AltTopicoForm
import com.agv.engdb.api.rest.model.Curso
import com.agv.engdb.api.rest.model.Topico
import com.agv.engdb.api.rest.model.Usuario
import org.springframework.stereotype.Component

@Component
class AltTopicoFormMapper: Mapper<AltTopicoForm, Topico> {
    override fun map(t: AltTopicoForm): Topico {
        return  Topico(
            id = t.id,
            titulo = t.titulo,
            mensagem = t.mensagem,
            curso = Curso(1,"",""),
            autor = Usuario(1,"","")
        )
    }

}