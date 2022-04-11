package ru.sylas.testwork.controller

import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Controller
import ru.sylas.testwork.model.ManyArray
import ru.sylas.testwork.service.manual.IManualRepository

@Controller
class ManualController(private val repository: IManualRepository) {
    @MessageMapping("/manual")
    @SendTo("/arrays")
    fun generateArray(): ManyArray {
        return repository.generateArray()
    }
}