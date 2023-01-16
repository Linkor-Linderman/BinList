package com.example.binlistapp.presentation


import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.binlistapp.presentation.card_detail_screen.CardDetailScreen
import com.example.binlistapp.presentation.request_list.RequestListScreen

@Composable
fun NavigationGraph(
    navController: NavHostController,
    innerPaddingValues: PaddingValues
) {
    NavHost(
        navController = navController,
        startDestination = Screen.CardDetailScreen.route,
        Modifier.padding(innerPaddingValues)
    ){
        composable(
            route = Screen.RequestListScreen.route
        ){
            RequestListScreen()
        }
        composable(
            route = Screen.CardDetailScreen.route
        ){
            CardDetailScreen()
        }
    }
}