package br.com.mind.castle.mindcastle

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication(exclude = [SecurityAutoConfiguration::class])
class MindCastleApplication

fun main(args: Array<String>) {
	runApplication<MindCastleApplication>(*args)
}
