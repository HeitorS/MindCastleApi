package com.agv.engdb.api.rest.mapper

import org.springframework.stereotype.Component
import com.agv.engdb.api.rest.dto.PessoaView
import com.agv.engdb.api.rest.model.Pessoa

@Component
class PessoaViewMapper: Mapper<Pessoa, PessoaView> {

    override fun map(p: Pessoa): PessoaView {
        return  PessoaView (
            nome = p.nome,
            sobrenome = p.sobrenome,
            email = p.email,
            telefone = p.telefone,
            celular = p.celular,
            data_nascimento = p.data_nascimento,
            sexo = p.sexo,
            id_usuario = p.id_usuario
        )
    }
}
