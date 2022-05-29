package com.agv.engdb.api.rest.mapper

import org.springframework.stereotype.Component
import com.agv.engdb.api.rest.dto.UsuarioForm
import com.agv.engdb.api.rest.model.Usuario

@Component
class UsuarioFormMapper: Mapper<UsuarioForm, Usuario> {
    override fun map(u: UsuarioForm): Usuario {
        return Usuario(
            nome = u.nome,
            cpf = u.cpf.replace(".","").replace("-","").replace("/",""),
            senha = u.senha,
            email = u.email,
            tentativa_login = 0
        )
    }
}