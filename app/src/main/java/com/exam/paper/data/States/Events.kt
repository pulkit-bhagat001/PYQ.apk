package com.exam.paper.data.States


sealed class Events {
    data class OnSemesterList(val semList:List<String>):Events()
    data class OnSubjectList(val subList:List<String>):Events()
    data class OnPaperList(val paperList:List<PdfItem>):Events()
    data class OnSemChanged(val sem:String):Events()
    data class OnSubChanged(val sub:String):Events()
    data class OnUrlClicked(val url:String):Events()
}
sealed class EventsForCombinedPapers {
    data class OnSemesterList(val semList:List<String>):EventsForCombinedPapers()
    data class OnSubjectList(val subList:List<String>):EventsForCombinedPapers()
    data class OnPaperList(val paperList:List<PdfItem>):EventsForCombinedPapers()
    data class OnSemChanged(val sem:String):EventsForCombinedPapers()
    data class OnSubChanged(val sub:String):EventsForCombinedPapers()
    data class OnUrlClicked(val url:String):EventsForCombinedPapers()
}




data class PdfItem(
    val name:String,
    val url:String
)