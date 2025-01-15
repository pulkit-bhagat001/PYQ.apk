package com.exam.paper.ui.common

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastForEachIndexed
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TabLayoutRow(tabList: List<TabItem>, pagerState: PagerState, scope: CoroutineScope) {
    TabRow(modifier = Modifier.fillMaxWidth(), selectedTabIndex = pagerState.currentPage, containerColor = Color.Transparent,
        indicator = {
        TabRowDefaults.Indicator(
            modifier = Modifier.tabIndicatorOffset(
                it[pagerState.currentPage]
            ), color = Color(0xFF56A45A)
        )
        }) {
        tabList.fastForEachIndexed { i, tabItem ->
            Tab(
                selected = i == pagerState.currentPage,
                onClick = { scope.launch { pagerState.animateScrollToPage(i) } },
                text = { if(i==pagerState.currentPage) Text(text = tabItem.name, fontWeight = FontWeight.Bold) else Text(text = tabItem.name)},
                icon = {
                    if (i == pagerState.currentPage) Icon(
                        imageVector = tabItem.iconSelected,
                        contentDescription = ""
                    ) else Icon(imageVector = tabItem.iconUnselected, contentDescription = "")
                },
                selectedContentColor = Color(0xFF56A45A),
                unselectedContentColor = Color.Gray,
                modifier = Modifier.fillMaxWidth()

            )
        }

    }
}