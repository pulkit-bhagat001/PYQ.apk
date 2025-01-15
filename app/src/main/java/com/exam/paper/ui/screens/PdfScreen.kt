package com.exam.paper.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.exam.paper.data.ExamViewModel
import com.rizzi.bouquet.ResourceType
import com.rizzi.bouquet.VerticalPDFReader
import com.rizzi.bouquet.VerticalPdfReaderState

import com.rizzi.bouquet.rememberVerticalPdfReaderState

@Composable
fun PdfScreen(examViewModel: ExamViewModel, navController: NavController, modifier: Modifier) {

    Box() {
        val state by examViewModel.uiState.collectAsState()
        val pdfState = rememberVerticalPdfReaderState(
            resource = ResourceType.Remote(state.url),
            isZoomEnable = true
        )
        Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {


            VerticalPDFReader(
                state = pdfState,
                modifier = modifier
                    .fillMaxSize()
                    .background(color = Color.Gray)
            )

        }
        ProgressIndicatorBox(
            pdfState, modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center)
        )

    }

}

@SuppressLint("DefaultLocale")
@Composable
fun ProgressIndicatorBox(pdfState: VerticalPdfReaderState, modifier: Modifier) {
    Box(modifier = modifier) {
        val loadPercent = pdfState.loadPercent.coerceIn(0, 100)
        if (loadPercent != 100) {
            CircularProgressIndicator(
                progress = { loadPercent / 100f },
                modifier = Modifier
                    .width(75.dp)
                    .align(Alignment.Center),
                strokeWidth = 10.dp
            )
            Text(
                text = String.format("%.0f%%", loadPercent.toFloat()),
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(top = 35.dp),
                color = Color(0xFF495D92),
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun PdfScreen1(examViewModel: ExamViewModel, navController: NavController, modifier: Modifier) {

    Box() {
        val state by examViewModel.uiStateForCombinedPapers.collectAsState()
        val pdfState = rememberVerticalPdfReaderState(
            resource = ResourceType.Remote(state.url),
            isZoomEnable = true
        )
        Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {


            VerticalPDFReader(
                state = pdfState,
                modifier = modifier
                    .fillMaxSize()
                    .background(color = Color.Gray)
            )

        }
        ProgressIndicatorBox1(
            pdfState, modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center)
        )

    }

}

@SuppressLint("DefaultLocale")
@Composable
fun ProgressIndicatorBox1(pdfState: VerticalPdfReaderState, modifier: Modifier) {
    Box(modifier = modifier) {
        val loadPercent = pdfState.loadPercent.coerceIn(0, 100)
        if (loadPercent != 100) {
            CircularProgressIndicator(
                progress = { loadPercent / 100f },
                modifier = Modifier
                    .width(75.dp)
                    .align(Alignment.Center),
                strokeWidth = 10.dp
            )
            Text(
                text = String.format("%.0f%%", loadPercent.toFloat()),
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(top = 35.dp),
                color = Color(0xFF495D92),
                fontWeight = FontWeight.Bold
            )
        }
    }
}