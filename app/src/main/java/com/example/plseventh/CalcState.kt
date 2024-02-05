package com.example.plseventh

data class CalcState (
    val num1 : String = "",
    val operation : CalcOperations ?= null,
    val num2 : String = "",

    val history : MutableList<CalcHistory> = mutableListOf()
)
