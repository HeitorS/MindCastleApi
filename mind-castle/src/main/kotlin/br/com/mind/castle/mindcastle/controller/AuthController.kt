package br.com.mind.castle.mindcastle.controller

import br.com.mind.castle.mindcastle.service.UserService
import br.com.mind.castle.mindcastle.dtos.RegisterDTO
import br.com.mind.castle.mindcastle.models.Message
import br.com.mind.castle.mindcastle.dtos.LoginDTO
import br.com.mind.castle.mindcastle.entity.User
import br.com.mind.castle.mindcastle.models.Token

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
class AuthController(private val userService: UserService) {

    private val key = "Lrc6jEQNYEfrwlCVocgvbfVV3Mq7xRb2BV2DAQmKBWyzHYMKdQbkPBZD1FYtfSBqFDfD62bmWEZN7mgdsLNiZw=="

    @PostMapping("register")
    fun register(@RequestBody body: RegisterDTO): ResponseEntity<User> {
        val user = User();
        user.nome = body.nome;
        user.email = body.email;
        user.senha = body.senha;

        return ResponseEntity.ok(this.userService.save(user));
    }

    @PostMapping("login")
    fun login(@RequestBody body: LoginDTO, response: HttpServletResponse): ResponseEntity<Any> {
        val user = this.userService.findByEmail(body.email)?:
            return ResponseEntity.badRequest().body(Message("Usuario não encontrado!"));

        if (!user.comparePassword(body.senha)) {
            return ResponseEntity.badRequest().body(Message("Senha inválida!"));
        }

        val issuer = user.id.toString();

        val jwt = Jwts.builder()
            .setIssuer(issuer)
            .setExpiration(Date(System.currentTimeMillis()+60*24*1000))
            .signWith(SignatureAlgorithm.HS512, key.toByteArray())
            .compact()

        val cookie = Cookie("jwt", jwt);
        cookie.isHttpOnly = true;

        response.addCookie(cookie);

        return ResponseEntity.ok(Token(jwt));
    }

    @GetMapping("user")
    fun user(@CookieValue("jwt") jwt: String?): ResponseEntity<Any> {
        try {
            if (jwt == null) {
                return ResponseEntity.status(401).body(Message("Não autorizado!"));
            }

            val body = Jwts.parser().setSigningKey(key.toByteArray()).parseClaimsJws(jwt).body;

            return ResponseEntity.ok(this.userService.getbyId(body.issuer.toInt()));
        } catch (e: Exception) {
            return ResponseEntity.status(401).body(Message("Não autorizado!"));
        }
    }

    @PostMapping("logout")
    fun logout(response: HttpServletResponse): ResponseEntity<Any> {
        var cookie = Cookie("jwt","")
        cookie.maxAge = 0
        response.addCookie(cookie);

        return ResponseEntity.ok(Message("Sucesso!"));
    }
}