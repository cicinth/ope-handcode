package br.com.ope

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class OpeAppApplication

fun main(args: Array<String>) {
    runApplication<OpeAppApplication>(*args)
}
