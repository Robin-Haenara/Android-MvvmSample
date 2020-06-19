package com.example.sampleapplication.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.classnote.domain.search.SearchRepo
import com.classnote.domain.search.SearchUseCase
import com.classnote.domain.search.SearchUseCaseInput

class SearchViewModel(val repo : SearchRepo, val usecase : SearchUseCase) : ViewModel(){

    val keywordData = object  : MutableLiveData<String>("") {
        override fun setValue(value: String?) {
            super.setValue(value)
            memberList.value = usecase.execute(
                object : SearchUseCaseInput{
                    override val keyword = value?: ""
                    override val repo = this@SearchViewModel.repo
                }
            ).filteredList
        }

        override fun postValue(value: String?) {
            super.postValue(value)
            memberList.value = usecase.execute(
                object : SearchUseCaseInput{
                    override val keyword = value?: ""
                    override val repo = this@SearchViewModel.repo
                }
            ).filteredList
        }
    }

    val memberList = MutableLiveData(repo.list)

}
