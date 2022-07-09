package com.api.rest.service

import com.api.rest.dto.EndPesForm
import com.api.rest.exception.EmailCadastradoException
import org.springframework.dao.EmptyResultDataAccessException
import com.api.rest.repository.PessoaRepository
import com.api.rest.mapper.PessoaFormMapper
import com.api.rest.mapper.PessoaViewMapper
import org.springframework.stereotype.Service
import com.api.rest.dto.PessoaForm
import com.api.rest.dto.PessoaView
import com.api.rest.mapper.EndPesFormMapper
import com.api.rest.repository.End_PesRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

@Service
class PessoaService (private val repository: PessoaRepository,
                     private val repositoryEnd: End_PesRepository,
                     private val pessoaViewMapper: PessoaViewMapper,
                     private val pessoaFormMapper: PessoaFormMapper,
                     private val endPesFormMapper: EndPesFormMapper
) {

    fun buscaPorEmail(email: String?): PessoaView {
        val pessoa = repository.findByEmail(email)
        return pessoaViewMapper.map(pessoa)
    }

    fun buscaTodos (paginacao: Pageable): Page<PessoaView> {
        return repository.findAll(paginacao).map { p -> pessoaViewMapper.map(p) }
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

    fun associaEndereco(dto: EndPesForm) {
        val end = endPesFormMapper.map(dto);
        repositoryEnd.save(end);
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