package com.example.jetpackcomposetutorial.satumeja.jetpack

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.jetpackcomposetutorial.R

@Preview
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onClickToHeadmasterScreen : () -> Unit = {},
    onClickToAddRecipeScreen : () -> Unit = {},
    onClickToCheckMenuScreen : () -> Unit = {}
) {
    Scaffold(
        topBar = {
            MyTopAppBar()
        },
        content = { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .paint(
                        painter = painterResource(id = R.drawable.backgraund_homepage),
                        contentScale = ContentScale.FillBounds
                    )
            ) {
                ConstraintLayout(
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth()
                        .padding(paddingValues)
                        .background(Color.Transparent)
                ) {
                    val (food, button) = createRefs()
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(205.dp)
                            .padding(start = 20.dp, end = 20.dp, top = 20.dp)
                            .clip(RoundedCornerShape(40.dp))
                            .paint(
                                painterResource(id = R.drawable.bar_makanan),
                                contentScale = ContentScale.FillBounds
                            )
                            .constrainAs(food) {
                                start.linkTo(parent.start)
                                end.linkTo(parent.end)
                            }
                    ) {
                        // Placeholder for RecyclerView
                        // Implement your own Composable if needed
                    }
                    Column(modifier = Modifier
                        .constrainAs(button) {
                            top.linkTo(parent.top)
                            bottom.linkTo(parent.bottom)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        }
                        .padding(top = 30.dp)
                    ) {
                        Button(
                            onClick = { onClickToHeadmasterScreen() },
                            modifier = Modifier
                                .paint(
                                    painterResource(id = R.drawable.button_background),
                                    contentScale = ContentScale.FillBounds
                                ),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Transparent,
                                contentColor = Color.Transparent,
                                disabledContainerColor = Color.Transparent,
                                disabledContentColor = Color.Transparent
                            ),
                        ) {
                            Text(
                                text = stringResource(id = R.string.headmaster),
                                color = Color.Black,
                                fontSize = 20.sp
                            )
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        Button(
                            onClick = { onClickToAddRecipeScreen() },
                            modifier = Modifier
                                .paint(
                                    painterResource(id = R.drawable.button_background)
                                    ,contentScale = ContentScale.FillBounds
                                ),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Transparent,
                                contentColor = Color.Transparent,
                                disabledContainerColor = Color.Transparent,
                                disabledContentColor = Color.Transparent
                            ),
                        ) {
                            Text(
                                text = "Resep Hari Ini",
                                color = Color.Black,
                                fontSize = 20.sp
                            )
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        Button(
                            onClick = { onClickToCheckMenuScreen() },
                            modifier = Modifier
                                .paint(
                                    painterResource(id = R.drawable.button_background),
                                    contentScale = ContentScale.FillBounds
                                ),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Transparent,
                                contentColor = Color.Transparent,
                                disabledContainerColor = Color.Transparent,
                                disabledContentColor = Color.Transparent
                            ),
                        ) {
                            Text(
                                text = stringResource(id = R.string.cek_menu),
                                color = Color.Black,
                                fontSize = 20.sp
                            )
                        }
                    }

                }
            }
        },
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenWithBottomBar(
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Satu Meja",
                        modifier = Modifier
                            .padding(start = 20.dp)
                    )
                },
                navigationIcon = {
                    Image(
                        painter = painterResource(id = R.drawable.gambar_account),
                        contentDescription = null,
                        modifier = Modifier.size(50.dp).padding(start = 20.dp)
                    )
                },
                actions = {
                    IconButton(onClick = { /* Handle click */ }) {
                        Icon(Icons.Filled.Search, contentDescription = "Search")
                    }
                    IconButton(onClick = { /* Handle click */ }) {
                        Icon(Icons.Filled.MoreVert, contentDescription = "More options")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Transparent,
                    scrolledContainerColor = Color.Transparent,
                    navigationIconContentColor = Color.Black,
                    titleContentColor = Color.Black,
                    actionIconContentColor = Color.Black)
            )
        },
        content = { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .paint(
                        painter = painterResource(id = R.drawable.backgraund_homepage),
                        contentScale = ContentScale.FillBounds
                    )
            ) {
                ConstraintLayout(
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth()
                        .padding(paddingValues)
                        .background(Color.Transparent)
                ) {
                    val (food, button) = createRefs()
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(205.dp)
                            .padding(start = 20.dp, end = 20.dp, top = 20.dp)
                            .clip(RoundedCornerShape(40.dp))
                            .paint(
                                painterResource(id = R.drawable.bar_makanan),
                                contentScale = ContentScale.FillBounds
                            )
                            .constrainAs(food) {
                                start.linkTo(parent.start)
                                end.linkTo(parent.end)
                            }
                    ) {
                        // Placeholder for RecyclerView
                        // Implement your own Composable if needed
                    }
                    Column(modifier = Modifier
                        .constrainAs(button) {
                            top.linkTo(parent.top)
                            bottom.linkTo(parent.bottom)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        }
                        .padding(top = 30.dp)
                    ) {
                        Button(
                            onClick = { /* Handle button 1 click */ },
                            modifier = Modifier
                                .paint(
                                    painterResource(id = R.drawable.button_background),
                                    contentScale = ContentScale.FillBounds
                                ),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Transparent,
                                contentColor = Color.Transparent,
                                disabledContainerColor = Color.Transparent,
                                disabledContentColor = Color.Transparent
                            ),
                        ) {
                            Text(
                                text = stringResource(id = R.string.headmaster),
                                color = Color.Black,
                                fontSize = 20.sp
                            )
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        Button(
                            onClick = { /* Handle button 2 click */ },
                            modifier = Modifier
                                .paint(
                                    painterResource(id = R.drawable.button_background)
                                    ,contentScale = ContentScale.FillBounds
                                ),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Transparent,
                                contentColor = Color.Transparent,
                                disabledContainerColor = Color.Transparent,
                                disabledContentColor = Color.Transparent
                            ),
                        ) {
                            Text(
                                text = "Resep Hari Ini",
                                color = Color.Black,
                                fontSize = 20.sp
                            )
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        Button(
                            onClick = { /* Handle button 3 click */ },
                            modifier = Modifier
                                .paint(
                                    painterResource(id = R.drawable.button_background),
                                    contentScale = ContentScale.FillBounds
                                ),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Transparent,
                                contentColor = Color.Transparent,
                                disabledContainerColor = Color.Transparent,
                                disabledContentColor = Color.Transparent
                            ),
                        ) {
                            Text(
                                text = stringResource(id = R.string.cek_menu),
                                color = Color.Black,
                                fontSize = 20.sp
                            )
                        }
                    }

                }
            }
        },
        bottomBar = {
            NavigationBar(
                containerColor = Color.Transparent
            ) {
                NavigationBarItem(
                    selected = true,
                    label = {
                        Text("Home")
                    },
                    icon = {
                        Icon(
                            Icons.Filled.Home,
                            contentDescription = null
                        )
                    },
                    onClick = {

                    }
                )
            }
        }
    )
}