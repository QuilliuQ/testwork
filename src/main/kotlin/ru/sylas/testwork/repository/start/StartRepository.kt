package ru.sylas.testwork.repository.start


import org.springframework.stereotype.Component
import ru.sylas.testwork.common.generateSimpleNumberArray
import ru.sylas.testwork.common.toManyArray
import ru.sylas.testwork.exceptions.BadSizeArrayException
import ru.sylas.testwork.model.ArraySize
import ru.sylas.testwork.model.ManyArray
import ru.sylas.testwork.model.OneArray
import ru.sylas.testwork.service.start.IStartRepository

/***
 * Репозиторий формирования изначального массива
 */


@Component
class StartRepository() : IStartRepository {
    override var list:ManyArray = listOf(OneArray(listOf(1,2,3))).toManyArray()

    /***
     * Репозиторий генерации чисел при нажатии кнопки "Сформировать"
     *@param size предполагает ввод длинны массива который будет сгенерирован.
     *@throws BadSizeArrayException срабатывает при некорректной длине массива.
     */

    override fun generateArray(size: ArraySize): ManyArray{
        if(size.value in 10..100){
        val tempList: MutableList<OneArray> = mutableListOf()
        repeat(5) {
            tempList.add(generateSimpleNumberArray(size.value))
        }
            list = tempList.toManyArray()
        return tempList.toList().toManyArray()
        }
        else{
            throw BadSizeArrayException()
        }
    }

}


