package br.com.mind.castle.mindcastle.service

import br.com.mind.castle.mindcastle.convert.RegisterDTOUser
import br.com.mind.castle.mindcastle.convert.UserToUserView
import br.com.mind.castle.mindcastle.dtos.RegisterDTO
import org.springframework.stereotype.Service

import br.com.mind.castle.mindcastle.repositories.UserRepository
import br.com.mind.castle.mindcastle.entity.User
import br.com.mind.castle.mindcastle.views.UserView
import java.util.*
import kotlin.jvm.optionals.getOrNull

@Service
class UserService (
    private val userRepository: UserRepository,
    private val convertUser: RegisterDTOUser,
    private val convertView: UserToUserView
    ) {

    fun save(user: RegisterDTO): User {
        return this.userRepository.save(this.convertUser.convert(user))
    }

    fun findByEmail(email: String): User? {
        return this.userRepository.findByEmail(email)
    }

    fun getbyId(id: Int): UserView {
        val user: User = this.userRepository.findById(id).get();
        return this.convertView.convert(user);
    }
}