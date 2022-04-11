package ru.sylas.testwork.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Controller
import ru.sylas.testwork.model.AutoGenEnable
import ru.sylas.testwork.model.ManyArray
import ru.sylas.testwork.service.auto.IAutoRepository

@Controller
class AutoController(private val repository: IAutoRepository, @Autowired private val simp: SimpMessagingTemplate) {
    private var enable:Boolean = false

    @MessageMapping("/enableAuto")
    fun switch(autoGenEnable: AutoGenEnable){
        enable = autoGenEnable.value
    }

    @MessageMapping("/auto")
    @Scheduled(fixedRate = 1000)
    fun generateArray(){
        do {     Thread.sleep(10000)
            simp.convertAndSend("/arrays", ManyArray(listOf(repository.generateArray()))) }
        while (enable)

    }
}
