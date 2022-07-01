package com.agv.engdb.api.rest.controller

import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.util.UriComponentsBuilder
import com.agv.engdb.api.rest.service.PessoaService
import org.springframework.http.ResponseEntity
import com.agv.engdb.api.rest.dto.PessoaForm
import com.agv.engdb.api.rest.dto.PessoaView
import org.springframework.http.HttpStatus
import javax.validation.Valid

@RestController
@RequestMapping("/pessoa")
class PessoaController (val service: PessoaService) {
    @GetMapping("/{id}")
    fun buscaPorId(@PathVariable id: Long): PessoaView {
        return service.buscaPorId(id);
    }

    @PostMapping
    @Transactional
    fun cadastrar(@RequestBody @Valid dto: PessoaForm, uriBuilder: UriComponentsBuilder): ResponseEntity<PessoaView> {
        val pessoaView = service.cadastrar(dto)
        val uri = uriBuilder.path("/pessoa/"+pessoaView.id_usuario).build().toUri()
        return ResponseEntity.created(uri).body(pessoaView)
    }

    @PutMapping
    @Transactional
    fun atualizar(@RequestBody @Valid form: PessoaForm): ResponseEntity<PessoaView> {
        val pessoaView = service.atualizar(form)
        return ResponseEntity.ok(pessoaView)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    fun deletar(@PathVariable id: Long) {
        service.deletar(id)
    }

}