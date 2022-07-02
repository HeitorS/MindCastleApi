package com.api.rest.mapper

import com.api.rest.dto.EnderecoForm
import com.api.rest.model.Endereco
import org.springframework.stereotype.Component

@Component
class EnderecoFormMapper: Mapper<EnderecoForm, Endereco> {
    override fun map(e: EnderecoForm): Endereco {
        return Endereco(
            cep = e.cep,
            logradouro = e.logradouro,
            bairro = e.bairro,
            estado = e.estado,
            cidade = e.cidade,
            numero = e.numero,
            complemento = e.complemento
        )
    }
}