package com.exam.paper.data

import androidx.lifecycle.ViewModel
import com.exam.paper.data.Repository.Repository
import com.exam.paper.data.States.Events
import com.exam.paper.data.States.EventsForCombinedPapers
import com.exam.paper.data.States.UiState
import com.exam.paper.data.States.UiStateForCombinedPapers
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class ExamViewModel @Inject constructor(private val repo:Repository):ViewModel() {
    private val _uiState= MutableStateFlow(UiState())
    val uiState=_uiState.asStateFlow()

    private val _uiStateForCombinedPapers= MutableStateFlow(UiStateForCombinedPapers())
    val uiStateForCombinedPapers=_uiStateForCombinedPapers.asStateFlow()


    fun onEvent(event:Events){
        when(event){
            is Events.OnPaperList -> {
                _uiState.value=_uiState.value.copy(
                    paperList = event.paperList
                )
            }
            is Events.OnSemChanged ->{
                _uiState.value=_uiState.value.copy(
                    sem = event.sem
                )

            }
            is Events.OnSemesterList ->{
                _uiState.value=_uiState.value.copy(
                    semList = event.semList,
                    loading = false
                )
            }
            is Events.OnSubChanged ->{
                _uiState.value=_uiState.value.copy(
                    sub = event.sub
                )
            }
            is Events.OnSubjectList -> {
                _uiState.value=_uiState.value.copy(
                    subList = event.subList
                )
            }

            is Events.OnUrlClicked ->{
                _uiState.value=_uiState.value.copy(
                   url = event.url
                )
            }


        }
    }

    fun onEventForCombinedPapers(events: EventsForCombinedPapers){
        when(events){
            is EventsForCombinedPapers.OnPaperList -> {
                _uiStateForCombinedPapers.value=_uiStateForCombinedPapers.value.copy(
                    paperList = events.paperList
                )
            }
            is EventsForCombinedPapers.OnSemChanged -> {
                _uiStateForCombinedPapers.value=_uiStateForCombinedPapers.value.copy(
                    sem = events.sem
                )
            }
            is EventsForCombinedPapers.OnSemesterList -> {
                _uiStateForCombinedPapers.value=_uiStateForCombinedPapers.value.copy(
                    semList = events.semList,
                    loading = false
                )
            }
            is EventsForCombinedPapers.OnSubChanged -> {
                _uiStateForCombinedPapers.value=_uiStateForCombinedPapers.value.copy(
                    sub=events.sub
                )
            }
            is EventsForCombinedPapers.OnSubjectList -> {
                _uiStateForCombinedPapers.value=_uiStateForCombinedPapers.value.copy(
                    subList = events.subList
                )
            }
            is EventsForCombinedPapers.OnUrlClicked -> {
                _uiStateForCombinedPapers.value=_uiStateForCombinedPapers.value.copy(
                    url = events.url
                )
            }
        }
    }

    fun loadSubjects(){
        repo.getSubjectsList("Year wise Papers",_uiState.value.sem, sendSubListToCallback = {
            onEvent(Events.OnSubjectList(it))
        })
    }
    fun loadSubjectsForCombined(){
        repo.getSubjectsList("Combined Papers",_uiStateForCombinedPapers.value.sem, sendSubListToCallback = {
            onEventForCombinedPapers(EventsForCombinedPapers.OnSubjectList(it))
        })
    }
    fun loadPapers(){
        repo.getPapersList("Year wise Papers",_uiState.value.sem,_uiState.value.sub, sendPaperListToCallback = {
            onEvent(Events.OnPaperList(it))
        })
    }
    fun loadPapersForCombined(){
        repo.getPapersList("Combined Papers",_uiStateForCombinedPapers.value.sem,_uiStateForCombinedPapers.value.sub, sendPaperListToCallback = {
            onEventForCombinedPapers(EventsForCombinedPapers.OnPaperList(it))
        })
    }



    init {
        repo.getSemestersList(root = "Year wise Papers", sendSemListToCallback = {
            onEvent(Events.OnSemesterList(it))
        }
        )
        repo.getSemestersList(root="Combined Papers", sendSemListToCallback = {
            onEventForCombinedPapers(EventsForCombinedPapers.OnSemesterList(it))
        })
    }

}