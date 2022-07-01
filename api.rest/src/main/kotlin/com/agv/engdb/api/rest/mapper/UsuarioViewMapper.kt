package com.agv.engdb.api.rest.mapper

import org.springframework.stereotype.Component
import com.agv.engdb.api.rest.dto.UsuarioView
import com.agv.engdb.api.rest.model.Usuario

@Component
class UsuarioViewMapper: Mapper<Usuario, UsuarioView> {
    override fun map(u: Usuario): UsuarioView {
        return UsuarioView(
            cpf = u.cpf,
            senha = u.senha,
            tentativa_login = u.tentativa_login
        )
    }
}