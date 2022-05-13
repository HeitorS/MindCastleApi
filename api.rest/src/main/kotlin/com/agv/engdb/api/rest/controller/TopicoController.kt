package com.agv.engdb.api.rest.controller

import com.agv.engdb.api.rest.dto.TopicoDto
import com.agv.engdb.api.rest.dto.TopicoView
import com.agv.engdb.api.rest.model.Topico
import com.agv.engdb.api.rest.service.TopicoService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/topicos")
class TopicoController(private val service:  TopicoService ) {

    @GetMapping
    fun listar(): List<TopicoView> {
        return service.listar()
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): Topico {
        return service.buscaPorId(id)
    }

    @PostMapping
    fun cadastrar(dto: TopicoDto) {
        service.cadastrar(dto);
    }
}