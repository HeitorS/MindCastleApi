package com.api.rest.mapper

import com.api.rest.dto.EnderecoView
import com.api.rest.model.Endereco
import org.springframework.stereotype.Component

@Component
class EnderecoViewMapper: Mapper<Endereco, EnderecoView> {
    override fun map(e: Endereco): EnderecoView {
        return EnderecoView(
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