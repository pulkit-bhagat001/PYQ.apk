package com.exam.paper.ui.screens

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastForEach
import androidx.compose.ui.util.fastForEachReversed
import androidx.navigation.NavController
import com.exam.paper.data.ExamViewModel
import com.exam.paper.data.States.Events
import com.exam.paper.data.States.EventsForCombinedPapers
import com.exam.paper.data.States.UiState
import com.exam.paper.data.States.UiStateForCombinedPapers
import com.exam.paper.data.navigation.PdfScreen
import com.exam.paper.data.navigation.PdfScreen1
import com.exam.paper.ui.common.CommonCard
import com.exam.paper.ui.common.CommonCard1
import com.exam.paper.ui.common.HorizontalPagerNav
import com.exam.paper.ui.common.TabLayout
import com.exam.paper.ui.common.TextButtonComponent
import com.exam.paper.ui.common.tabList

@Composable
fun MainPage(examViewModel: ExamViewModel, navController: NavController) {

    val pagerState = rememberPagerState(pageCount = { tabList.size })
    val state by examViewModel.uiState.collectAsState()
    val state1 by examViewModel.uiStateForCombinedPapers.collectAsState()
        Box(
            Modifier
                .fillMaxSize()
                .background(Color(0xFF151010)), contentAlignment = Alignment.TopStart
        ) {
            Column {
                TabLayout(pagerState)
                HorizontalPagerNav(pagerState, examViewModel, state, navController,state1)

            }
        }

}

@Composable
fun LowerPage(examViewModel: ExamViewModel, state: UiState, navController: NavController) {
    if (state.loading) {
        Box(
            Modifier
                .fillMaxSize()
                .background(Color.Black)
                .background(Color.White.copy(alpha = 0.1f)),
            contentAlignment = Alignment.Center
        ) {
            Column(

                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                CircularProgressIndicator()
                Text(text = "Loading", fontWeight = FontWeight.Bold, color = Color.White)


            }
        }
    } else {
        val scrollState = rememberScrollState()
        Spacer(Modifier.height(10.dp))
        Row(modifier = Modifier.horizontalScroll(scrollState).padding(start = 5.dp)) {
            state.semList.fastForEach {
                TextButtonComponent(
                    onclick = {
                        examViewModel.onEvent(Events.OnSemChanged(it))
                        examViewModel.loadSubjects()
                    },
                    text = it,
                    selected = it == state.sem
                )
            }
        }
        Spacer(Modifier.height(8.dp))
        if (state.subList.isNotEmpty()) {
            Row(modifier = Modifier.horizontalScroll(scrollState).padding(start = 5.dp)) {
                state.subList.fastForEach {
                    TextButtonComponent(
                        onclick = {
                            examViewModel.onEvent(Events.OnSubChanged(it))
                            examViewModel.loadPapers()
                        },
                        text = it,
                        selected = it == state.sub
                    )
                }
            }
        }

        Spacer(Modifier.height(8.dp))
        if (state.paperList.isNotEmpty()) {
            Spacer(Modifier.height(20.dp))
            val slideOffset = remember { Animatable(400f) }
            LaunchedEffect(state.paperList) {
                slideOffset.snapTo(400f)  // Reset position and start animating from 400f below the normal position
                slideOffset.animateTo(targetValue = 0f,//reach the normal position after going from 400f to 0f
                    animationSpec = tween(400)
                )
            }
            state.paperList.fastForEachReversed{ paper ->
                CommonCard(state, paper, onCardClicked = { data ->
                    examViewModel.onEvent(Events.OnUrlClicked(data))
                    navController.navigate(PdfScreen) {
                        launchSingleTop = true
                    }
                }, slideOffset = slideOffset)

                Spacer(Modifier.height(30.dp))
            }
        }
    }
}
@Composable
fun LowerPage1(
    examViewModel: ExamViewModel,
    navController: NavController,
    state1: UiStateForCombinedPapers
) {
    if (state1.loading) {
        Box(
            Modifier
                .fillMaxSize()
                .background(Color.Black)
                .background(Color.White.copy(alpha = 0.1f)),
            contentAlignment = Alignment.Center
        ) {
            Column(

                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                CircularProgressIndicator()
                Text(text = "Loading", fontWeight = FontWeight.Bold, color = Color.White)


            }
        }
    } else {
        val scrollState = rememberScrollState()
        Spacer(Modifier.height(10.dp))
        Row(modifier = Modifier.horizontalScroll(scrollState).padding(start = 5.dp)) {
            state1.semList.fastForEach {
                TextButtonComponent(
                    onclick = {
                        examViewModel.onEventForCombinedPapers(EventsForCombinedPapers.OnSemChanged(it))
                        examViewModel.loadSubjectsForCombined()
                    },
                    text = it,
                    selected = it == state1.sem
                )

            }

        }
        Spacer(Modifier.height(8.dp))
        if (state1.subList.isNotEmpty()) {
            Row(modifier = Modifier.horizontalScroll(scrollState).padding(start = 5.dp)) {
                state1.subList.fastForEach {
                    TextButtonComponent(
                        onclick = {
                            examViewModel.onEventForCombinedPapers(EventsForCombinedPapers.OnSubChanged(it))
                            examViewModel.loadPapersForCombined()
                        },
                        text = it,
                        selected = it == state1.sub
                    )
                }
            }
        }
        Spacer(Modifier.height(8.dp))
        if (state1.paperList.isNotEmpty()) {
            val slideOffset = remember{ Animatable(400f) }
            LaunchedEffect(state1.paperList) {
                slideOffset.snapTo(400f)
                slideOffset.animateTo(targetValue = 0f,
                    animationSpec = tween(400)
                )
            }

            Spacer(Modifier.height(20.dp))
            state1.paperList.fastForEachReversed {
                CommonCard1(state1, it, onCardClicked = { data ->
                    examViewModel.onEventForCombinedPapers(EventsForCombinedPapers.OnUrlClicked(data))

                    navController.navigate(PdfScreen1) {
                        launchSingleTop = true
                    }


                },slideOffset)
                Spacer(Modifier.height(30.dp))
            }

        }
    }
}


