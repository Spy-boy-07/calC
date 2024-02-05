package com.example.plseventh

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.plseventh.ui.theme.Black
import com.example.plseventh.ui.theme.BlueLight1
import com.example.plseventh.ui.theme.BlueLight2
import com.example.plseventh.ui.theme.PureBlack
import com.example.plseventh.ui.theme.Purple80

@Composable
fun CalcButtons(
    symbol : String,
    modifier: Modifier,
    onClick: () -> Unit
) {
    Box(
        contentAlignment = Alignment.Center,

        modifier = Modifier
            .clip(RoundedCornerShape(25))
            .clickable { onClick() }
//            .border(1.dp, PureBlack, RoundedCornerShape(25))
            .then(modifier),

    ){
        Text(
            text = symbol,
            fontSize = 28.sp,
            color = BlueLight2
        )
//        Image(painter = painterResource(id = R.drawable.ic_history), contentDescription = "")

    }
}