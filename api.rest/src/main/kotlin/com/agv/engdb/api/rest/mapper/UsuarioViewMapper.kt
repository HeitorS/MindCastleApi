package com.agv.engdb.api.rest.mapper

import org.springframework.stereotype.Component
import com.agv.engdb.api.rest.dto.UsuarioView
import com.agv.engdb.api.rest.model.Usuario

@Component
class UsuarioViewMapper: Mapper<Usuario, UsuarioView> {
    override fun map(u: Usuario): UsuarioView {
        return UsuarioView(
            nome = u.nome,
            cpf = u.cpf,
            senha = u.senha,
            email = u.email,
            tentativa_login = u.tentativa_login
        )
    }
}