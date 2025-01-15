package com.exam.paper.ui.common

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.exam.paper.data.ExamViewModel
import com.exam.paper.data.States.UiState
import com.exam.paper.data.States.UiStateForCombinedPapers
import com.exam.paper.ui.screens.LowerPage
import com.exam.paper.ui.screens.LowerPage1

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HorizontalPagerNav(
    pagerState: PagerState,
    examViewModel: ExamViewModel,
    state: UiState,
    navController: NavController,
    state1: UiStateForCombinedPapers
) {
    HorizontalPager(state = pagerState) {
        when(it){
            0->{
                LazyColumn {
                    item { LowerPage(examViewModel,state,navController) }
                }

            }
            1->{
                LazyColumn {
                item { LowerPage1(examViewModel,navController,state1) }
            }}
        }
    }
}