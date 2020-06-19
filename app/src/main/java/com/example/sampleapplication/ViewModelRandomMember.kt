package com.example.sampleapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.classnote.domain.model.KidsnoteMember
import com.example.sampleapplication.random.RepoRandomMember
import com.example.sampleapplication.random.UseCaseRandomMember

class ViewModelRandomMember(
    private val usecase : UseCaseRandomMember,
    private val repo : RepoRandomMember
) : ViewModel() {

    val member = MutableLiveData<KidsnoteMember>().apply {
        value = usecase.execute(repo).member
    }

    fun getNext() {
        member.value = usecase.execute(repo).member
    }
}