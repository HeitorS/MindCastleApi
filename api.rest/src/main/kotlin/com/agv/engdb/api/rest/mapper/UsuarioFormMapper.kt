package com.agv.engdb.api.rest.mapper

import org.springframework.stereotype.Component
import com.agv.engdb.api.rest.dto.UsuarioForm
import com.agv.engdb.api.rest.model.Usuario

@Component
class UsuarioFormMapper: Mapper<UsuarioForm, Usuario> {
    override fun map(u: UsuarioForm): Usuario {
        return Usuario(
            cpf = u.cpf.replace(".","").replace("-","").replace("/",""),
            senha = u.senha,
            tentativa_login = 0
        )
    }
}