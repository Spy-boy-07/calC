package com.example.plseventh

sealed class CalcActions {
    data class Number(val num : Int) : CalcActions()
    object Delete : CalcActions()
    object Clear : CalcActions()
    object Calculate : CalcActions()
    object Decimal : CalcActions()
    object ClearHistory : CalcActions()
    data class Operation(val operation: CalcOperations) : CalcActions()
}