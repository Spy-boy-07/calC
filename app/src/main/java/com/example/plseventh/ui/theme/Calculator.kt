package com.example.plseventh.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
//import androidx.compose.foundation.layout.FlowColumnScopeInstance.align
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.plseventh.CalcActions
import com.example.plseventh.CalcButtons
import com.example.plseventh.CalcOperations
import com.example.plseventh.CalcState
import com.example.plseventh.CalcViewModel
import kotlin.math.min


@Composable
fun Calculator(
    state: CalcState,
    buttonSpacing : Dp = 8.dp,
    modifier: Modifier = Modifier,
    onAction : (CalcActions) -> Unit
) {
    Box(modifier = modifier){
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(220.dp)
            .align(Alignment.TopCenter)
        ){
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                items(state.history) { historyEntry ->
                    Column {
                        Text(
                            text = "${historyEntry.equation} = ${historyEntry.result}",
                            textAlign = TextAlign.End,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 12.dp, horizontal = 8.dp),
                            fontWeight = FontWeight.Light,
                            fontSize = 20.sp,
                            color = BlueDark2,
                            maxLines = 2
                        )
                    Divider(
                        color = BlueDark2,
                        thickness = 1.dp,
                        modifier = Modifier.padding(horizontal = 8.dp)
                    )
                    }
                }
            }
        }

        Column (
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {

            Text(
                text = state.num1 + (state.operation?.symbol ?: "") + state.num2,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 60.dp * 2, max = 60.dp * 2 )
                    .padding(vertical = 16.dp),
                fontWeight = FontWeight.Light,
                fontSize = 42.sp,
                color = BlueLight2,
                maxLines = 2,
                style = TextStyle(lineHeight = 44.sp)
            )
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {

                CalcButtons(symbol = "CH", modifier = Modifier
                    .background(BlueDark1)
                    .aspectRatio(1f)
                    .weight(1f),
                    onClick = {
                        onAction(CalcActions.ClearHistory)
                    }
                )
                CalcButtons(symbol = "AC", modifier = Modifier
                    .background(BlueDark1)
                    .aspectRatio(1f)
                    .weight(1f),
                    onClick = {
                        onAction(CalcActions.Clear)
                    }
                )
                CalcButtons(symbol = "Del", modifier = Modifier
                    .background(BlueDark1)
                    .aspectRatio(1f)
                    .weight(1f),
                    onClick = {
                        onAction(CalcActions.Delete)
                    }
                )
                CalcButtons(symbol = "/", modifier = Modifier
                    .background(BlueDark2)
                    .aspectRatio(1f)
                    .weight(1f),
                    onClick = {
                        onAction(CalcActions.Operation(CalcOperations.Divide))
                    }
                )
            }

            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalcButtons(symbol = "7", modifier = Modifier
                    .background(PureBlack)
                    .aspectRatio(1f)
                    .weight(1f),
                    onClick = {
                        onAction(CalcActions.Number(7))
                    }
                )
                CalcButtons(symbol = "8", modifier = Modifier
                    .background(PureBlack)
                    .aspectRatio(1f)
                    .weight(1f),
                    onClick = {
                        onAction(CalcActions.Number(8))
                    }
                )
                CalcButtons(symbol = "9", modifier = Modifier
                    .background(PureBlack)
                    .aspectRatio(1f)
                    .weight(1f),
                    onClick = {
                        onAction(CalcActions.Number(9))
                    }
                )
                CalcButtons(symbol = "x", modifier = Modifier
                    .background(BlueDark2)
                    .aspectRatio(1f)
                    .weight(1f),
                    onClick = {
                        onAction(CalcActions.Operation(CalcOperations.Multiply))
                    }
                )
            }

            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalcButtons(symbol = "4", modifier = Modifier
                    .background(PureBlack)
                    .aspectRatio(1f)
                    .weight(1f),
                    onClick = {
                        onAction(CalcActions.Number(4))
                    }
                )
                CalcButtons(symbol = "5", modifier = Modifier
                    .background(PureBlack)
                    .aspectRatio(1f)
                    .weight(1f),
                    onClick = {
                        onAction(CalcActions.Number(5))
                    }
                )
                CalcButtons(symbol = "6", modifier = Modifier
                    .background(PureBlack)
                    .aspectRatio(1f)
                    .weight(1f),
                    onClick = {
                        onAction(CalcActions.Number(6))
                    }
                )
                CalcButtons(symbol = "-", modifier = Modifier
                    .background(BlueDark2)
                    .aspectRatio(1f)
                    .weight(1f),
                    onClick = {
                        onAction(CalcActions.Operation(CalcOperations.Subtract))
                    }
                )
            }

            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalcButtons(symbol = "1", modifier = Modifier
                    .background(PureBlack)
                    .aspectRatio(1f)
                    .weight(1f),
                    onClick = {
                        onAction(CalcActions.Number(1))
                    }
                )
                CalcButtons(symbol = "2", modifier = Modifier
                    .background(PureBlack)
                    .aspectRatio(1f)
                    .weight(1f),
                    onClick = {
                        onAction(CalcActions.Number(2))
                    }
                )
                CalcButtons(symbol = "3", modifier = Modifier
                    .background(PureBlack)
                    .aspectRatio(1f)
                    .weight(1f),
                    onClick = {
                        onAction(CalcActions.Number(3))
                    }
                )
                CalcButtons(symbol = "+", modifier = Modifier
                    .background(BlueDark2)
                    .aspectRatio(1f)
                    .weight(1f),
                    onClick = {
                        onAction(CalcActions.Operation(CalcOperations.Add))
                    }
                )
            }

            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalcButtons(symbol = "0", modifier = Modifier
                    .background(PureBlack)
                    .aspectRatio(2f)
                    .weight(2f),
                    onClick = {
                        onAction(CalcActions.Number(0))
                    }
                )
                CalcButtons(symbol = ".", modifier = Modifier
                    .background(PureBlack)
                    .aspectRatio(1f)
                    .weight(1f),
                    onClick = {
                        onAction(CalcActions.Decimal)
                    }
                )
                CalcButtons(symbol = "=", modifier = Modifier
                    .background(BlueDark2)
                    .aspectRatio(1f)
                    .weight(1f),
                    onClick = {
                        onAction(CalcActions.Calculate)
                    }
                )
            }

        }
    }
}




