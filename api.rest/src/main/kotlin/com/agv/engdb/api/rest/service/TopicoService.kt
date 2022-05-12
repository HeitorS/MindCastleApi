package com.agv.engdb.api.rest.service

import com.agv.engdb.api.rest.model.Curso
import com.agv.engdb.api.rest.model.Topico
import com.agv.engdb.api.rest.model.Usuario
import org.springframework.stereotype.Service
import java.util.*

@Service
class TopicoService (private var topicos: List<Topico>) {

    init {
        val topico = Topico (
            id = 1,
            titulo = "Duvida sobre Kotlin",
            mensagem = "Variaveis no Kotlin",
            curso = Curso(
                id = 1,
                nome = "Kotlin",
                categoria = "Programacao"
            ),
            autor = Usuario(
                id = 1,
                nome = "Ana",
                email = "ana@email.com"
            )
        )

        val topico2 = Topico (
            id = 2,
            titulo = "Duvida sobre Kotlin 2",
            mensagem = "Variaveis no Kotlin 2",
            curso = Curso(
                id = 1,
                nome = "Kotlin",
                categoria = "Programacao"
            ),
            autor = Usuario(
                id = 1,
                nome = "Ana",
                email = "ana@email.com"
            )
        )

        val topico3 = Topico (
            id = 3,
            titulo = "Duvida sobre Kotlin 3",
            mensagem = "Variaveis no Kotlin 3",
            curso = Curso(
                id = 1,
                nome = "Kotlin",
                categoria = "Programacao"
            ),
            autor = Usuario(
                id = 1,
                nome = "Ana",
                email = "ana@email.com"
            )
        )

        topicos = Arrays.asList(topico,topico2,topico3)
    }

    fun listar(): List<Topico> {
        return topicos
    }

    fun buscaPorId(id: Long): Topico {
        return topicos.stream().filter({ t -> t.id == id}).findFirst().get()
    }
}