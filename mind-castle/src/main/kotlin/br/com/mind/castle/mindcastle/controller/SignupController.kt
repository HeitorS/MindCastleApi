package br.com.mind.castle.mindcastle.controller

import br.com.mind.castle.mindcastle.service.UserService
import br.com.mind.castle.mindcastle.dtos.RegisterDTO
import br.com.mind.castle.mindcastle.entity.User

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

import org.springframework.http.ResponseEntity

@RestController
@RequestMapping("signup")
class SignupController(private val userService: UserService) {

    @PostMapping
    fun signup(@RequestBody user: RegisterDTO): ResponseEntity<User> {
        return ResponseEntity.ok(this.userService.save(user))
    }

}