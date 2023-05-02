package br.com.mind.castle.mindcastle.controller

import br.com.mind.castle.mindcastle.service.UserService
import br.com.mind.castle.mindcastle.dtos.RegisterDTO
import br.com.mind.castle.mindcastle.models.Message
import br.com.mind.castle.mindcastle.dtos.LoginDTO
import br.com.mind.castle.mindcastle.entity.User
import br.com.mind.castle.mindcastle.models.Token
import br.com.mind.castle.mindcastle.service.TokenService

import jakarta.servlet.http.HttpServletResponse
import jakarta.servlet.http.Cookie

import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.Jwts

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CookieValue
import org.springframework.web.bind.annotation.GetMapping
import java.security.SecureRandom
import java.util.Base64

import java.util.Date

@RestController
@RequestMapping("auth")
class AuthController(
    private val userService: UserService
) {

    @PostMapping("login")
    fun login(@RequestBody body: LoginDTO): ResponseEntity<Any> {
        val user = this.userService.findByEmail(body.email)?:
        return ResponseEntity.badRequest().body(Message("Usuario não encontrado!"));

        if (!user.comparePassword(body.senha)) {
            return ResponseEntity.badRequest().body(Message("Usuário ou senha inválida!"));
        }

        return ResponseEntity.ok(user);
    }

    @PostMapping("logout")
    fun logout(): ResponseEntity<Any> {
        return ResponseEntity.ok(Message("Sucesso!"));
    }
}