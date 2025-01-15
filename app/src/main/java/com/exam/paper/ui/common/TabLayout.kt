package com.exam.paper.ui.common

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Newspaper
import androidx.compose.material.icons.outlined.Book
import androidx.compose.material.icons.outlined.Newspaper
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.vector.ImageVector


val tabList= listOf(
    TabItem("Year wise Papers",Icons.Outlined.Newspaper,Icons.Filled.Newspaper),
    TabItem("Combined Papers",Icons.Outlined.Book,Icons.Filled.Book)
)
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TabLayout(pagerState: PagerState) {
    val scope= rememberCoroutineScope()
    TabLayoutRow(tabList,pagerState,scope)
}


data class TabItem(
    val name:String,
    val iconUnselected:ImageVector,
    val iconSelected:ImageVector
)