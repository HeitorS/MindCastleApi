package br.com.mind.castle.mindcastle.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import java.time.LocalDateTime


@Entity
@Table(name="usuario")
class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Int = 0

    @Column
    var nome = ""

    @Column(unique = true)
    var email = ""

    @Column
    var senha = ""
        @JsonIgnore
        get() = field
        set(value) {
            val passwordEncoder = BCryptPasswordEncoder()
            field = passwordEncoder.encode(value)
        }

    @Column()
    var dataCriacao = LocalDateTime.now()

    constructor(nome: String, email: String, senha: String) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    fun comparePassword(password: String): Boolean {
        return BCryptPasswordEncoder().matches(password, this.senha)
    }


}