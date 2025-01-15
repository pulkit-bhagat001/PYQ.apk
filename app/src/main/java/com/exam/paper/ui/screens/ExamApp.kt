package com.exam.paper.ui.screens

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.exam.paper.data.ExamViewModel
import com.exam.paper.data.navigation.MainPage
import com.exam.paper.data.navigation.PdfScreen
import com.exam.paper.data.navigation.PdfScreen1

@Composable
fun ExamApp(examViewModel: ExamViewModel= hiltViewModel(),modifier: Modifier) {

 val navController= rememberNavController()
 NavHost(navController=navController, startDestination = MainPage, modifier = modifier) {
        composable<MainPage>{MainPage(examViewModel,navController)}
        composable<PdfScreen>{ PdfScreen(examViewModel,navController,modifier) }
     composable<PdfScreen1>{ PdfScreen1(examViewModel,navController,modifier) }

    }
}