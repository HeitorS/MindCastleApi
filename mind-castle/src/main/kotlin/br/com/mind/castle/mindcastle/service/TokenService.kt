package br.com.mind.castle.mindcastle.service

import br.com.mind.castle.mindcastle.entity.User
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.stereotype.Service
import java.util.*

@Service
class TokenService(
    private val userService: UserService
) {
    private val key = "Lrc6jEQNYEfrwlCVocgvbfVV3Mq7xRb2BV2DAQmKBWyzHYMKdQbkPBZD1FYtfSBqFDfD62bmWEZN7mgdsLNiZw=="

    fun gerarToken(user: User): String {
        val issuer = user.id.toString();

        return Jwts.builder()
            .setIssuer(issuer)
            .setExpiration(Date(System.currentTimeMillis()+60*24*1000))
            .signWith(SignatureAlgorithm.HS512, key.toByteArray())
            .compact()
    }

    fun validaToken(jwt: String): Claims {
        return Jwts.parser().setSigningKey(key.toByteArray()).parseClaimsJws(jwt).body;
    }
}