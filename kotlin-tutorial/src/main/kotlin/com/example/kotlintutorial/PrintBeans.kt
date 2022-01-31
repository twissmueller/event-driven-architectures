package com.example.kotlintutorial

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationListener
import org.springframework.stereotype.Component

@Component
class PrintBeans @Autowired constructor(applicationContext: ApplicationContext) :
    ApplicationListener<ApplicationReadyEvent> {

    val applicationContext = applicationContext

    override fun onApplicationEvent(event: ApplicationReadyEvent) {
        applicationContext.beanDefinitionNames.forEach { beanName -> println(beanName) }
    }

}