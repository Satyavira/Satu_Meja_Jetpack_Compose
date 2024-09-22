package com.example.jetpackcomposetutorial.satumeja.jetpack

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.jetpackcomposetutorial.R
import kotlinx.coroutines.launch

@Preview
@Composable
fun AuthInterface(
    modifier: Modifier = Modifier,
    onClickToLoginScreen : () -> Unit = {},
    onClickToRegisterScreen : () -> Unit = {}
    ) {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp //The width of the available screen space in dp units excluding the area occupied by window insets.
    ConstraintLayout(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .paint(
                painterResource(id = R.drawable.background_app),
                contentScale = ContentScale.FillBounds
            )
    ) {
        val coroutineScope = rememberCoroutineScope()
        val (logo, button) = createRefs()
        Image(
            painterResource(id = R.drawable.logosvg),
            contentDescription = null,
            modifier = Modifier
                .padding(top = ((screenHeight / 4) - 100).dp)
                .constrainAs(logo) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .height(100.dp)
                .width(140.dp)
        )
        Column(
            modifier = Modifier
                .constrainAs(button) {
                    top.linkTo(logo.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
        ) {
            Button(
                modifier = Modifier
                    .paint(
                        painterResource(R.drawable.button_background)
                    ),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = Color.Transparent,
                    disabledContainerColor = Color.Transparent,
                    disabledContentColor = Color.Transparent
                ),
                onClick = {
                    coroutineScope.launch {
                        onClickToLoginScreen()
                    }
                }
            ) {
                Text("Login", color = Color.Black, fontSize = 20.sp)
            }
            Spacer(modifier = Modifier
                .height(20.dp)
            )
            Button(
                modifier = Modifier
                    .paint(
                        painterResource(R.drawable.button_background)
                    ),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = Color.Transparent,
                    disabledContainerColor = Color.Transparent,
                    disabledContentColor = Color.Transparent
                ),
                onClick = {
                    coroutineScope.launch {
                        onClickToRegisterScreen()
                    }
                }
            ) {
                Text("Register", color = Color.Black, fontSize = 20.sp)
            }
        }
    }
}
