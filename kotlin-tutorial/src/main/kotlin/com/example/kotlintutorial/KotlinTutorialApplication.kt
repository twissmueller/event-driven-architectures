package com.example.kotlintutorial

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
class KotlinTutorialApplication

fun main(args: Array<String>) {
    runApplication<KotlinTutorialApplication>(*args)
}