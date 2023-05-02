package br.com.mind.castle.mindcastle.controller

import br.com.mind.castle.mindcastle.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("user")
class UserController(
    private val userService: UserService
) {
    @GetMapping("{id}")
    fun user(@PathVariable(value = "id") id: Int): ResponseEntity<Any> {
        return ResponseEntity.ok(this.userService.getbyId(id));
    }
}