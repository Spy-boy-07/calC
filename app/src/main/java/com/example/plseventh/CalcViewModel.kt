package com.example.plseventh

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CalcViewModel : ViewModel() {
    fun onAction(action: CalcActions) {
        when(action){
            is CalcActions.Number -> enterNum(action.num)
            is CalcActions.Decimal -> enterDecimal()
            is CalcActions.Clear -> state = state.copy(num1 = "", operation = null, num2 = "")
            is CalcActions.Operation -> enterOperation(action.operation)
            is CalcActions.Delete -> performDeletion()
            is CalcActions.Calculate -> performCalculation()
            is CalcActions.ClearHistory -> state = state.copy(history = mutableListOf())
        }

    }

    private fun performCalculation() {
        val number1 = state.num1.toDoubleOrNull()
        var number2 = state.num2.toDoubleOrNull()
        if (number1 != null && number2 != null){
            val result = when(state.operation) {
                is CalcOperations.Add -> number1 + number2
                is CalcOperations.Subtract -> number1 - number2
                is CalcOperations.Divide -> number1 / number2
                is CalcOperations.Multiply -> number1 * number2
                null -> return
            }
            val equation = state.num1 + state.operation?.symbol + state.num2
            val calcHistory = CalcHistory(equation,result.toString())
            state = state.copy(num1 = result.toString(), num2 = "", operation = null,
                history = state.history.toMutableList().apply{
                    add(calcHistory)
                } )
        }
    }

    private fun performDeletion() {
        when{
            state.num2.isNotBlank() -> state = state.copy(
                num2 = state.num2.dropLast(1)
            )
            state.operation != null -> state = state.copy(
                operation = null
            )
            state.num1.isNotBlank() -> state = state.copy(
                num1 = state.num1.dropLast(1)
            )
        }
    }

    private fun enterDecimal() {
        if (
            state.operation == null &&
            !state.num1.contains(".") &&
            state.num1.isNotBlank()
            ){
            state = state.copy(num1 = state.num1 + ".")
            return
        }
        if(!state.num2.contains(".") && state.num2.isNotBlank()){
            state = state.copy(num2 = state.num2 + ".")
            return
        }
    }

    private fun enterOperation(operation: CalcOperations) {
        if (state.num1.isNotBlank()){
            state = state.copy(operation = operation)
        }
    }

    private fun enterNum(num: Int) {
        if (state.operation==null){
            if (state.num1.length >= 8){
                return
            }
            state = state.copy(
                num1 = state.num1 + num
            )
            return
        }
        if (state.num2.length >= 8){
            return
        }
        state = state.copy(
            num2 = state.num2 + num
        )
    }

    var state by mutableStateOf(CalcState())
        private set
}