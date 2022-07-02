package com.api.rest.service

import com.api.rest.exception.EmailCadastradoException
import org.springframework.dao.EmptyResultDataAccessException
import com.api.rest.repository.EnderecoRepository
import com.api.rest.mapper.EnderecoFormMapper
import com.api.rest.mapper.EnderecoViewMapper
import com.api.rest.dto.EnderecoForm
import com.api.rest.dto.EnderecoView
import org.springframework.stereotype.Service

@Service
class EnderecoService(private val repository: EnderecoRepository,
                      private val enderecoViewMapper: EnderecoViewMapper,
                      private val enderecoFormMapper: EnderecoFormMapper
) {
    fun buscaPorCep(cep: String): EnderecoView {
        return enderecoViewMapper.map(repository.getByCep(cep))
    }

    fun cadastrar(dto: EnderecoForm): EnderecoView {
        try {
            this.buscaPorCep(dto.cep)
            throw EmailCadastradoException()
        } catch (ex: EmptyResultDataAccessException) {
            val newPessoa = enderecoFormMapper.map(dto);
            repository.save(newPessoa)
            return enderecoViewMapper.map(newPessoa)
        }
    }

    fun deletar(cep: String) {
        repository.deleteByCep(cep)
    }
}