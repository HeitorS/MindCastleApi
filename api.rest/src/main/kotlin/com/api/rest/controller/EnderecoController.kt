package com.api.rest.controller

import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.util.UriComponentsBuilder
import org.springframework.http.ResponseEntity
import com.api.rest.service.EnderecoService
import org.springframework.http.HttpStatus
import com.api.rest.dto.EnderecoForm
import com.api.rest.dto.EnderecoView
import javax.validation.Valid

@RestController
@RequestMapping("/endereco")
class EnderecoController (val service: EnderecoService) {

    @GetMapping("/{cep}")
    fun buscaPorCep(@PathVariable cep: String): EnderecoView {
        return service.buscaPorCep(cep);
    }

    @PostMapping
    @Transactional
    fun cadastrar(@RequestBody @Valid dto: EnderecoForm, uriBuilder: UriComponentsBuilder): ResponseEntity<EnderecoView> {
        val enderecoView = service.cadastrar(dto)
        val uri = uriBuilder.path("/endereco/"+enderecoView.cep).build().toUri()
        return ResponseEntity.created(uri).body(enderecoView)
    }

    @DeleteMapping("/{cep}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    fun deletar(@PathVariable cep: String) {
        service.deletar(cep)
    }
}