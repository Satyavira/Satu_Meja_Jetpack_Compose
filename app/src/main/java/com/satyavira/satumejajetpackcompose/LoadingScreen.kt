package com.example.jetpackcomposetutorial.satumeja.jetpack

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.jetpackcomposetutorial.R
import kotlinx.coroutines.delay

@Preview
@Composable
fun LoadingScreen(onTimeout: () -> Unit = {})  {
    LaunchedEffect(Unit) {
        delay(5000L)
        onTimeout()
    }
    ConstraintLayout(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .paint(
                painterResource(id = R.drawable.background_app),
                contentScale = ContentScale.FillBounds
            )
    ) {
        val (logo, loading) = createRefs()
        Image(
            painterResource(id = R.drawable.logosvg),
            contentDescription = null,
            modifier = Modifier
                .constrainAs(logo) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .height(100.dp)
                .width(140.dp)
        )
        CircularProgressIndicator(
            modifier = Modifier
                .constrainAs(loading) {
                    top.linkTo(logo.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            color = Color(android.graphics.Color.parseColor("#EA6D35")),
            strokeWidth = 7.dp,
        )
    }
}
