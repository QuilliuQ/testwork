package ru.sylas.testwork.service.auto

import ru.sylas.testwork.model.OneArray


interface IAutoRepository {
    fun generateArray(): OneArray
}