package com.agv.engdb.api.rest.service

import com.agv.engdb.api.rest.exception.SenhaDiferenteCadstroException
import com.agv.engdb.api.rest.exception.CpfCadastradoException
import org.springframework.dao.EmptyResultDataAccessException
import com.agv.engdb.api.rest.repository.UsuarioRepository
import com.agv.engdb.api.rest.mapper.UsuarioViewMapper
import com.agv.engdb.api.rest.mapper.UsuarioFormMapper
import com.agv.engdb.api.rest.dto.UsuarioForm
import com.agv.engdb.api.rest.dto.UsuarioView
import org.springframework.stereotype.Service

@Service
class UsuarioService (
    private val repository: UsuarioRepository,
    private val usuarioViewMapper: UsuarioViewMapper,
    private val usuarioFormMapper: UsuarioFormMapper
) {
    fun buscaPorCPF(cpf: String): UsuarioView {
        val usuario = repository.findByCpf(cpf.replace(".","").replace("-","").replace("/",""))
        return usuarioViewMapper.map(usuario)
    }

    fun cadastrar(dto: UsuarioForm): UsuarioView {
        if (dto.senha != dto.confSenha) {
            throw SenhaDiferenteCadstroException()
        }
        try {
            this.buscaPorCPF(dto.cpf)
            throw CpfCadastradoException()
        } catch (ex: EmptyResultDataAccessException) {
            val newUs = usuarioFormMapper.map(dto)
            repository.save(newUs)
            return usuarioViewMapper.map(newUs)
        }
    }

    fun atualizar(form: UsuarioForm): UsuarioView {
        if (form.senha != form.confSenha) {
            throw SenhaDiferenteCadstroException()
        }
        val us = repository.findByCpf(form.cpf.replace(".","").replace("-","").replace("/",""))
        us.nome = form.nome
        us.senha = form.senha
        us.email = form.email
        repository.save(us)
        return usuarioViewMapper.map(us)
    }

    fun deletar(cpf: String) {
        repository.deleteByCpf(cpf.replace(".","").replace("-","").replace("/",""))
    }
}
