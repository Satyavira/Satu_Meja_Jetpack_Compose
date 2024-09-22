package com.example.jetpackcomposetutorial.satumeja.jetpack

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.jetpackcomposetutorial.R
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import kotlinx.coroutines.launch

@Preview
@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    onClickToHomeScreen : () -> Unit = {}
) {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp //The width of the available screen space in dp units excluding the area occupied by window insets.
    val coroutineScope = rememberCoroutineScope()
    ConstraintLayout(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .paint(
                painterResource(id = R.drawable.background_app),
                contentScale = ContentScale.FillBounds
            )
    ) {
        val (logo, text, field, button) = createRefs()
        Image(
            painter = painterResource(id = R.drawable.logosvg),
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

        Text(
            text = stringResource(id = R.string.login_school),
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp,
                lineHeight = 32.sp
            ),
            modifier = Modifier
                .constrainAs(text) {
                    top.linkTo(logo.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .padding(top = 30.dp),
        )
        Column(
            modifier = Modifier
                .constrainAs(field) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
        ) {
            OutlinedTextField(
                value = "",
                onValueChange = {},
                placeholder = { Text(text = stringResource(id = R.string.school_name)) },
                modifier = Modifier
                    .size(283.dp, 50.dp)
                    .background(color = Color(android.graphics.Color.parseColor("#EDE9E9")), shape = RoundedCornerShape(5.dp))
                    .border(BorderStroke(0.dp, androidx.compose.ui.graphics.Color.Transparent))
            )

        }
        Button(
            onClick = {
                coroutineScope.launch {
                    onClickToHomeScreen()
                }
            },
            modifier = Modifier
                .padding(top = ((screenHeight * 3 / 4) - 25).dp)
                .paint(
                    painterResource(R.drawable.button_background)
                )
                .constrainAs(button) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
                contentColor = Color.Transparent,
                disabledContainerColor = Color.Transparent,
                disabledContentColor = Color.Transparent
            ),
        ) {
            Text(text = stringResource(id = R.string.login), color = Color.Black, fontSize = 20.sp)
        }

    }
}