package com.example.jetpackcomposetutorial.satumeja.jetpack

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.jetpackcomposetutorial.R

@Preview
@Composable
fun AddRecipeScreen(
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            MyTopAppBar()
        },
        content = { paddingValues ->
            Box(modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .paint(
                    painterResource(R.drawable.backgraund_homepage),
                    contentScale = ContentScale.FillBounds
                )
            ) {
                ConstraintLayout(
                    modifier = Modifier
                        .padding(paddingValues)
                        .fillMaxWidth()
                        .fillMaxHeight()
                ) {
                    val (top) = createRefs()
                    Row(
                        modifier = Modifier
                            .constrainAs(top) {
                                start.linkTo(parent.start)
                            }
                            .padding(start = 20.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painterResource(R.drawable.chef),
                            contentDescription = null,
                        )
                        Column(
                            verticalArrangement = Arrangement.Center,
                        ) {
                            Text(stringResource(R.string.chef), fontSize = 16.sp, fontWeight = FontWeight.Bold)
                            Text(stringResource(R.string.fill_in_the_list_below))
                        }
                    }
                }
            }

        }
    )
}