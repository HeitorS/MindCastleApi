package com.api.rest.mapper

import org.springframework.stereotype.Component
import com.api.rest.dto.UsuarioView
import com.api.rest.model.Usuario

@Component
class UsuarioViewMapper: Mapper<Usuario, UsuarioView> {
    override fun map(u: Usuario): UsuarioView {
        return UsuarioView(
            id = u.id,
            cpf = u.cpf,
            senha = u.senha,
            tentativa_login = u.tentativa_login
        )
    }
}