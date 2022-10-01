package com.api.rest.service

import com.api.rest.dto.UserDetail
import org.springframework.dao.EmptyResultDataAccessException
import com.api.rest.exception.SenhaDiferenteCadstroException
import com.api.rest.exception.CpfCadastradoException
import com.api.rest.repository.UsuarioRepository
import com.api.rest.exception.NotFoundException
import org.springframework.stereotype.Service
import com.api.rest.mapper.UsuarioViewMapper
import com.api.rest.mapper.UsuarioFormMapper
import com.api.rest.dto.UsuarioForm
import com.api.rest.dto.UsuarioView
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCrypt

@Service
class UsuarioService (
    private val repository: UsuarioRepository,
    private val usuarioViewMapper: UsuarioViewMapper,
    private val usuarioFormMapper: UsuarioFormMapper
): UserDetailsService {
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
        var cpf = form.cpf.replace(".","").replace("-","").replace("/","")
        val us = repository.findByCpf(cpf)
        us.senha = BCrypt.hashpw(form.senha, BCrypt.gensalt())
        repository.save(us)
        return usuarioViewMapper.map(us)
    }

    fun deletar(cpf: String) {
        val usuario = repository.findByCpf(cpf.replace(".","").replace("-","").replace("/",""))
        if (usuario != null) {
            repository.deleteByCpf(cpf.replace(".","").replace("-","").replace("/",""))
        } else {
            throw NotFoundException()
        }
    }

    override fun loadUserByUsername(username: String?): UserDetails {
        val user = repository.findByCpf(username) ?: throw java.lang.RuntimeException()
        return UserDetail(user)
    }
}
