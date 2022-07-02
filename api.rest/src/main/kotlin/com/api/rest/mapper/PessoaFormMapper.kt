package com.api.rest.mapper

import org.springframework.stereotype.Component
import com.api.rest.dto.PessoaForm
import com.api.rest.model.Pessoa
import java.time.LocalDateTime

@Component
class PessoaFormMapper: Mapper<PessoaForm, Pessoa> {
    override fun map(p: PessoaForm): Pessoa {
        val day = p.data_nascimento.split("/")[0];
        val month = p.data_nascimento.split("/")[1];
        val year = p.data_nascimento.split("/")[2];
        return Pessoa(
            nome = p.nome,
            sobrenome = p.sobrenome,
            email = p.email,
            telefone = p.telefone,
            celular = p.celular,
            data_nascimento = LocalDateTime.of(year.toInt(),month.toInt(),day.toInt(),0,0) ,
            sexo = p.sexo,
            id_usuario = p.id_usuario
        )
    }
}