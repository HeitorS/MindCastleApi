package br.com.mind.castle.mindcastle.convert


import br.com.mind.castle.mindcastle.views.UserView
import br.com.mind.castle.mindcastle.entity.User

import org.springframework.stereotype.Component

@Component
class UserToUserView: Mapper<User, UserView> {
    override fun convert(o: User): UserView {
        return UserView(
            nome = o.nome,
            email = o.email,
            dataCriacao = o.dataCriacao
        )
    }
}