package br.com.mind.castle.mindcastle.convert


import br.com.mind.castle.mindcastle.views.LoginView
import br.com.mind.castle.mindcastle.entity.User

import org.springframework.stereotype.Component

@Component
class UserToLoginView: Mapper<User, LoginView> {
    override fun convert(o: User): LoginView {
        return LoginView(
            nome = o.nome,
            email = o.email,
            dataCriacao = o.dataCriacao
        )
    }
}