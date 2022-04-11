package ru.sylas.testwork.common


import ru.sylas.testwork.model.ManyArray
import ru.sylas.testwork.model.OneArray

/***
 *Метод выборки случайный чисел из последовательности
 * @param size предполагает ввод длинны массива который будет выбрать.
 *В задании указано 6 так что это просто элемент расширяемости
 */

fun OneArray.withOutDuplicate(size :Int):OneArray {
    val tempList = mutableListOf<Int>()
    while(tempList.size <= size){
        val tempItem = this.value.random().takeIf {
            !tempList.contains(it)
        }
        if(tempItem!=null)
        { tempList.add(tempItem)
        }
    }

    return tempList.toList().toOneArray()

}


/***
 *Метод генерации последовательности простых чисел
 * @param size предполагает ввод длинны массива который будет сгенерирован.
 *В задании указано 6 так что это просто элемент расширяемости
 */

fun generateSimpleNumberArray(size: Int): OneArray {
    val tempList = mutableListOf<Int>()
    var num = 2
    while (tempList.size < size) {
        if ((2 until num).none { num % it == 0 }) {
            tempList.add(num)
        }
        num++
    }
    return tempList.toOneArray()
}

/***
 * Функции расширения для мапинга списков
 */

fun List<Int>.toOneArray() =
    OneArray(
        value = this
    )
fun List<OneArray>.toManyArray() =
    ManyArray(
        value = this
    )

