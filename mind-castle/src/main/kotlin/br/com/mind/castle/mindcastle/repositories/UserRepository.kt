package br.com.mind.castle.mindcastle.repositories

import br.com.mind.castle.mindcastle.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User,Int> {

    fun findByEmail(email: String): User?
}