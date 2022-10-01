package com.api.rest.dto

import com.api.rest.model.Usuario
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class UserDetail(private val usuario: Usuario) :UserDetails  {
    override fun getAuthorities() = null

    override fun getPassword() = usuario.senha

    override fun getUsername() = usuario.cpf

    override fun isAccountNonExpired() = true

    override fun isAccountNonLocked() = true

    override fun isCredentialsNonExpired() = true

    override fun isEnabled() = true
}