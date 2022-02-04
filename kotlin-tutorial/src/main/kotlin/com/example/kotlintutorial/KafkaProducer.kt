package com.example.kotlintutorial

import org.springframework.kafka.core.KafkaTemplate
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.time.ZonedDateTime

@Component
class KafkaProducer(private val kafkaTemplate: KafkaTemplate<String, TimestampEvent>) {

    @Scheduled(fixedRate = 5000)
    fun send() {
        val event = TimestampEvent(timestamp = ZonedDateTime.now())
        kafkaTemplate.send("tutorial-topic", event)
        println("Sent: ${event.timestamp.toString()}")
    }

}