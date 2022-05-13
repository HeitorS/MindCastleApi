package com.agv.engdb.api.rest.controller

import com.agv.engdb.api.rest.dto.TopicoForm
import com.agv.engdb.api.rest.dto.TopicoView
import com.agv.engdb.api.rest.model.Topico
import com.agv.engdb.api.rest.service.TopicoService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/topicos")
class TopicoController(val service:  TopicoService ) {

    @GetMapping
    fun listar(): List<TopicoView> {
        return service.listar()
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): TopicoView {
        return service.buscaPorId(id)
    }

    @PostMapping
    fun cadastrar(@RequestBody dto: TopicoForm) {
        service.cadastrar(dto);
    }
}