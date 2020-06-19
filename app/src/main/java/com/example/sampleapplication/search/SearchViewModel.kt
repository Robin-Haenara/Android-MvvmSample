package com.example.sampleapplication.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sampleapplication.random.KidsnoteMemberDB

class SearchViewModel(val repo : KidsnoteMemberDB) : ViewModel(){

    val keywordData = object  : MutableLiveData<String>("") {
        override fun setValue(value: String?) {
            super.setValue(value)
            if (value?.isNotEmpty() == true) {
                memberList.value = repo.list.filter {
                    it.name.toLowerCase().contains(value.toLowerCase() )
                            || it.part.toLowerCase().contains(value.toLowerCase() )
                }
            } else {
                memberList.value = repo.list
            }
        }

        override fun postValue(value: String?) {
            super.postValue(value)
            if (value?.isNotEmpty() == true) {
                memberList.value = repo.list.filter {
                    it.name.toLowerCase().contains(value.toLowerCase() )
                            || it.part.toLowerCase().contains(value.toLowerCase() )
                }
            } else {
                memberList.value = repo.list
            }
        }
    }

    val memberList = MutableLiveData(repo.list)

}
