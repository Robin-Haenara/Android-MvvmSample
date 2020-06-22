package com.example.sampleapplication.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import com.classnote.domain.search.*
import com.example.sampleapplication.nav.NavigationMapper

class SearchViewModel(
    private val repo : SearchRepo,
    private val usecase : SearchUseCase,
    private val usecaseNavi : SearchToAddUseCase) : ViewModel(){

    val keywordData = object  : MutableLiveData<String>("") {
        override fun setValue(value: String?) {
            super.setValue(value)
            memberList.value = usecase.execute(
                object : SearchUseCaseInput{
                    override val keyword = value?: ""
                    override val repo = this@SearchViewModel.repo
                }
            ).filteredList.also{
                isEmtpty.value = it.isEmpty()
            }
        }

        override fun postValue(value: String?) {
            super.postValue(value)
            memberList.value = usecase.execute(
                object : SearchUseCaseInput{
                    override val keyword = value?: ""
                    override val repo = this@SearchViewModel.repo
                }
            ).filteredList.also{
                isEmtpty.value = it.isEmpty()
            }
        }
    }

    val memberList = MutableLiveData(repo.list)

    var isEmtpty = MutableLiveData(repo.list.isEmpty())

    val event = MutableLiveData<String>()
    val eventNavi = MutableLiveData<NavDirections>()

    fun moveToAdd() {
        eventNavi.value =
            NavigationMapper.map(
                usecaseNavi.execute(object : SearchToAddUseCaseInput {
                    override val keyword = keywordData.value
                }).destination
            )
    }

}
