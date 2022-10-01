package com.api.rest.mapper

import org.springframework.stereotype.Component
import com.api.rest.dto.UsuarioForm
import com.api.rest.model.Usuario
import org.springframework.security.crypto.bcrypt.BCrypt

@Component
class UsuarioFormMapper: Mapper<UsuarioForm, Usuario> {
    override fun map(u: UsuarioForm): Usuario {
        return Usuario(
            cpf = u.cpf.replace(".","").replace("-","").replace("/",""),
            senha = BCrypt.hashpw(u.senha,BCrypt.gensalt()),
            tentativa_login = 0
        )
    }
}