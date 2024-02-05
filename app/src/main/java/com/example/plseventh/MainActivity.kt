package com.example.plseventh

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.plseventh.ui.theme.Black
import com.example.plseventh.ui.theme.Calculator
import com.example.plseventh.ui.theme.PlseventhTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlseventhTheme {
                var viewModel = viewModel<CalcViewModel>()
                var state = viewModel.state
                var buttonspace = 8.dp
                Calculator(
                    state = state,
                    onAction = viewModel::onAction,
                    buttonSpacing = buttonspace,
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Black)
                        .padding(16.dp)
                    )
            }
        }
    }
}

@Preview
@Composable
fun Tryal() {
    var viewModel = viewModel<CalcViewModel>()
    var state = viewModel.state
    var buttonspace = 8.dp
    Calculator(
        state = state,
        onAction = viewModel::onAction,
        buttonSpacing = buttonspace,
        modifier = Modifier
            .fillMaxSize()
            .background(Black)
            .padding(16.dp)
    )
}