package com.agv.engdb.api.rest.service

import com.agv.engdb.api.rest.exception.EmailCadastradoException
import org.springframework.dao.EmptyResultDataAccessException
import com.agv.engdb.api.rest.repository.PessoaRepository
import com.agv.engdb.api.rest.mapper.PessoaFormMapper
import com.agv.engdb.api.rest.mapper.PessoaViewMapper
import org.springframework.stereotype.Service
import com.agv.engdb.api.rest.dto.PessoaForm
import com.agv.engdb.api.rest.dto.PessoaView

@Service
class PessoaService (private val repository: PessoaRepository,
                     private val pessoaViewMapper: PessoaViewMapper,
                     private val pessoaFormMapper: PessoaFormMapper
) {

    fun buscaPorId(id: Long): PessoaView {
        return pessoaViewMapper.map(repository.getById(id))
    }

    fun cadastrar(dto: PessoaForm): PessoaView {
        try {
            repository.findByIdUsuario(dto.id_usuario)
            throw EmailCadastradoException()
        } catch (ex: EmptyResultDataAccessException) {
            val newPessoa = pessoaFormMapper.map(dto);
            repository.save(newPessoa)
            return pessoaViewMapper.map(newPessoa)
        }
    }

    fun atualizar(form: PessoaForm): PessoaView {
        val ps = repository.findByIdUsuario(form.id_usuario)
        ps.email = form.email
        ps.telefone = form.telefone
        ps.celular = form.celular
        repository.save(ps)
        return pessoaViewMapper.map(ps)
    }

    fun deletar(id: Long) {
        repository.deleteById(id)
    }
}