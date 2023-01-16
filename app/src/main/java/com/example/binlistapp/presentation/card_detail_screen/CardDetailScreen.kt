package com.example.binlistapp.presentation.card_detail_screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.binlistapp.presentation.NavigationGraph
import com.example.binlistapp.presentation.Screen
import com.example.binlistapp.presentation.card_detail_screen.components.BinNumbersTextField
import com.example.binlistapp.presentation.card_detail_screen.components.BottomNavigationBar
import com.example.binlistapp.presentation.card_detail_screen.components.CardInformationTable
import com.example.binlistapp.presentation.request_list.RequestListScreen

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = { BottomNavigationBar(navController = navController) }
    ) {
        NavigationGraph(
            navController = navController,
            it
        )
    }
}

@Composable
fun CardDetailScreen(
    viewModel: CardDetailViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Enter your BIN",
            style = MaterialTheme.typography.h4,
            color = Color.White,
            modifier = Modifier
                .padding(top = 32.dp, bottom = 16.dp)
        )
        BinNumbersTextField(
            modifier = Modifier.padding(16.dp),
            binNumber = viewModel.bin
        )

        Button(
            onClick = { viewModel.getCardDetail(viewModel.bin.value) }
        ) {
            Text(
                text = "Search",
                style = MaterialTheme.typography.h5
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Box(modifier = Modifier.fillMaxWidth()) {
            state.cardDetail?.let { cardDetail ->
                CardInformationTable(
                    cardDetail = cardDetail,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .align(Alignment.Center)
                )
            }
            if (state.error.isNotBlank()) {
                Text(
                    text = state.error,
                    color = MaterialTheme.colors.error,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .align(Alignment.Center)
                )
            }
            if (state.isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }

    }
}