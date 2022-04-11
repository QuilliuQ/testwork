package ru.sylas.testwork.repository.manual

import org.springframework.stereotype.Component
import ru.sylas.testwork.common.toManyArray
import ru.sylas.testwork.common.withOutDuplicate
import ru.sylas.testwork.model.ManyArray
import ru.sylas.testwork.service.manual.IManualRepository
import ru.sylas.testwork.service.start.IStartRepository


/***
 * Репозиторий генерации чисел при нажатии на кнопку "Сгенерировать"
 *@param repository позволяет выбрать из
 */


@Component
class ManualRepository(private val repository: IStartRepository) : IManualRepository {
    override fun generateArray(): ManyArray {
       return repository.list.value.map {oneArray->
            oneArray.withOutDuplicate(6)
        }.toManyArray()
    }
}




