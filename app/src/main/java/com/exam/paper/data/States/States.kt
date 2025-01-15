package com.exam.paper.data.States

data class UiState(
    val semList: List<String> = emptyList(),
    val subList:List<String> = emptyList(),
    val paperList:List<PdfItem> = emptyList(),
    val sem:String="",
    val sub:String="",
    val loading:Boolean=true,
    val url:String=""
)

data class UiStateForCombinedPapers(
    val semList: List<String> = emptyList(),
    val subList:List<String> = emptyList(),
    val paperList:List<PdfItem> = emptyList(),
    val sem:String="",
    val sub:String="",
    val loading:Boolean=true,
    val url:String=""
)