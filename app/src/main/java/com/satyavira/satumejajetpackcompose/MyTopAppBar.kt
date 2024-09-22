package com.example.jetpackcomposetutorial.satumeja.jetpack

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposetutorial.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar() {
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
}