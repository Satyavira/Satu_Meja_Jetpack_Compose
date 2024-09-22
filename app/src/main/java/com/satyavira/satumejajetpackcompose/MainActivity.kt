package com.example.jetpackcomposetutorial.satumeja.jetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SatuMeja()
        }
    }
}

@Composable
fun SatuMeja() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "loading"
    ) {
        composable(route = "loading") {
            LoadingScreen {
                navController.navigate(route = "LoginFragment") {
                    popUpTo(route = "loading") {
                        inclusive = true
                    }
                }
            }
        }

        composable(route = "LoginFragment") {

        }
    }
}

@Preview
@Composable
fun SatuMejaCoba() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "loading"
    ) {
        composable(route = "loading") {
            LoadingScreen {
                navController.navigate(route = "authInterface") {
                    popUpTo(route = "loading") {
                        inclusive = true
                    }
                }
            }
        }
        navigation(
            startDestination = "authInterface",
            route = "auth"
        ) {
            composable(route = "authInterface") {
                AuthInterface(
                    onClickToLoginScreen = {
                        navController.navigate("login")
                    },
                    onClickToRegisterScreen = {
                        navController.navigate("register")
                    }
                )
            }
            composable(route = "login") {
                LoginScreen() {
                    navController.navigate("home") {
                        popUpTo(route = "auth") {
                            inclusive = true
                        }
                    }
                }
            }
            composable(route = "register") {
                RegisterScreen() {
                    navController.navigate("home") {
                        popUpTo(route = "auth") {
                            inclusive = true
                        }
                    }
                }
            }
        }
        navigation(
            startDestination = "home",
            route = "main"
        ) {
            composable(route = "home") {
                HomeScreen(
                    onClickToHeadmasterScreen = {},
                    onClickToAddRecipeScreen = {},
                    onClickToCheckMenuScreen = {}
                )
            }
            composable(route = "recipe") {

            }
            composable(route = "menu") {

            }
        }
        navigation(
            startDestination = "headmaster",
            route = "admin"
        ) {
            composable(route = "headmaster") {

            }
            composable(route = "statistic") {

            }
            composable(route = "add_account") {

            }
        }
    }
}

@Composable
fun SatuMejaBackground() {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(
            brush = Brush.linearGradient(
                colorStops = arrayOf(
                    0.0f to Color(android.graphics.Color.parseColor("#3EA0FF")),
                    0.56f to Color(android.graphics.Color.parseColor("#96CCFF")),
                    1.0f to Color(android.graphics.Color.parseColor("#E9F4FF"))
                )
            ), shape = RectangleShape
        )
    ) {

    }
}