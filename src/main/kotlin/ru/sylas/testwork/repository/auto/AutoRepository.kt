package ru.sylas.testwork.repository.auto

import org.springframework.stereotype.Component
import ru.sylas.testwork.common.withOutDuplicate
import ru.sylas.testwork.model.OneArray
import ru.sylas.testwork.service.auto.IAutoRepository
import ru.sylas.testwork.service.start.IStartRepository


/***
 * Репозиторий автогенерации массива, при нажатии на кнопку авто.
 */

@Component
class AutoRepository(private val repository: IStartRepository) : IAutoRepository {
    override fun generateArray(): OneArray {
        return repository.list.value.random().withOutDuplicate(6)
    }
}