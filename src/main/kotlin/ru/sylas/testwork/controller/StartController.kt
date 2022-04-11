package ru.sylas.testwork.controller

import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.stereotype.Controller
import ru.sylas.testwork.exceptions.BadSizeArrayException
import ru.sylas.testwork.model.ArraySize
import ru.sylas.testwork.service.start.IStartRepository


@Controller
class StartController(private val repository: IStartRepository) {
    @MessageMapping("/set_array_lenght")
    @Throws(BadSizeArrayException::class)
    fun generateArray(size:ArraySize){
        repository.generateArray(size)
    }
}




