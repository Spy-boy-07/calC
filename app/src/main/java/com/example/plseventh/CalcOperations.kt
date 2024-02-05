package com.example.plseventh

sealed class CalcOperations(var symbol : String) {
    object Add : CalcOperations("+")
    object Subtract : CalcOperations("-")
    object Multiply : CalcOperations("x")
    object Divide : CalcOperations("/")
}