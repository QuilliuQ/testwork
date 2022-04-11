package ru.sylas.testwork.exceptions

class BadSizeArrayException(override val message: String? = "Размер массива должен быть от 10 до 100"):Exception(message) {
}