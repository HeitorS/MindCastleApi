package br.com.mind.castle.mindcastle.convert

import br.com.mind.castle.mindcastle.dtos.RegisterDTO
import br.com.mind.castle.mindcastle.entity.User
import org.springframework.stereotype.Component

@Component
class RegisterDTOUser: Mapper<RegisterDTO, User> {
    override fun convert(o: RegisterDTO): User {
        return User (
            nome = o.nome,
            email = o.email,
            senha = o.senha
        )
    }

}