package com.example.roombd

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.roombd.ui.theme.Autorization
import com.example.roombd.ui.theme.MainUi
import com.example.roombd.ui.theme.Registration

@Composable
fun AppNavigation()
{
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "auth") {
        composable("auth") { Autorization(navController) }
        composable("home") { MainUi() }
        composable("reg") { Registration(navController) }
    }
}