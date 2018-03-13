package com.starwars


import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication


@SpringBootApplication
@EntityScan("com.starwars.data.model")
class Application

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}

