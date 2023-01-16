package com.example.binlistapp.presentation.request_list

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.binlistapp.presentation.request_list.components.RequestListItem

@Composable
fun RequestListScreen(
    viewModel: RequestListViewModel = hiltViewModel()
){
    val requests = viewModel.listOfRequest.value
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ){
        item { 
            Text(
                text = "Requests",
                style = MaterialTheme.typography.h4,
                color = Color.White,
                modifier = Modifier
                    .padding(top = 32.dp, bottom = 16.dp, start = 16.dp)
            )
        }
        items(requests){request ->
            RequestListItem(request = request)
        }
    }
}