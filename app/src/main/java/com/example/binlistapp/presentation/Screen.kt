package com.example.binlistapp.presentation

sealed class Screen(val route: String){
    object CardDetailScreen: Screen("card_detail")
    object RequestListScreen: Screen("request_list")
}
