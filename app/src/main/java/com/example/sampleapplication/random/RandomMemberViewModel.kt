package com.example.sampleapplication.random

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.classnote.domain.model.KidsnoteMember
import com.classnote.domain.random.RandomMemberUseCase

class RandomMemberViewModel (
    private val usecase : RandomMemberUseCase,
    private val repo : RandomMemberRepoImpl
) : ViewModel() {

    val member = MutableLiveData<KidsnoteMember>().apply {
        value = usecase.execute(repo).member
    }

    fun getNext() {
        member.value = usecase.execute(repo).member
    }
}