package com.example.sampleapplication.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import com.classnote.domain.model.KidsnoteMember
import com.classnote.domain.search.*
import com.example.sampleapplication.nav.NavigationMapper

class SearchViewModel(
    private val repo : SearchRepo,
    private val usecase : SearchUseCase,
    private val usecaseNavi : SearchToAddUseCase) : ViewModel(){
    val memberList = MutableLiveData<List<KidsnoteMember>>()
    var isEmtpty = MutableLiveData<Boolean>(false)

    val keywordData = object  : MutableLiveData<String>("") {
        override fun setValue(value: String?) {
            super.setValue(value)
            val observableList = usecase.execute(
                object : SearchUseCaseInput{
                    override val keyword = value?: ""
                    override val repo = this@SearchViewModel.repo
                }
            ).filteredList.toList()

            observableList.subscribe { list ->
                memberList.value =  list
                isEmtpty.value = list.isEmpty()
            }
        }
    }

    init {
        repo.list.toList().subscribe { list ->
            memberList.value = list
        }
    }

    val naviEvent = MutableLiveData<NavDirections>()

    fun moveToAdd() {
        naviEvent.value =
            NavigationMapper.map(
                usecaseNavi.execute(object : SearchToAddUseCaseInput {
                    override val keyword = keywordData.value
                }).destination
            )
    }

}
