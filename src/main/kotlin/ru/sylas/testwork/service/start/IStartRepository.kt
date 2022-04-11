package ru.sylas.testwork.service.start


import ru.sylas.testwork.model.ArraySize
import ru.sylas.testwork.model.ManyArray


interface IStartRepository {
    val list:ManyArray
    fun generateArray(size:ArraySize):ManyArray
}