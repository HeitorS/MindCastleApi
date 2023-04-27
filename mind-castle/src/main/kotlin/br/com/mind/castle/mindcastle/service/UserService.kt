package br.com.mind.castle.mindcastle.service

import org.springframework.stereotype.Service

import br.com.mind.castle.mindcastle.repositories.UserRepository
import br.com.mind.castle.mindcastle.entity.User
import java.util.*

@Service
class UserService (
    private val userRepository: UserRepository
    ) {

    fun save(user: User): User {
        return this.userRepository.save(user)
    }

    fun findByEmail(email: String): User? {
        return this.userRepository.findByEmail(email)
    }

    fun getbyId(id: Int): Optional<User> {
        return this.userRepository.findById(id);
    }
}