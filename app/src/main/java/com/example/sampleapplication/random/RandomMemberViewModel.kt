package com.example.sampleapplication.random

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.classnote.domain.model.KidsnoteMember
import com.classnote.domain.random.RandomMemberRepo
import com.classnote.domain.random.RandomMemberUseCase

class RandomMemberViewModel (
    private val usecase : RandomMemberUseCase,
    private val repo : RandomMemberRepo
) : ViewModel() {

    val member = MutableLiveData<KidsnoteMember>().apply {
        usecase.execute(repo).member.subscribe { m -> this.value = m }
    }

    fun getNext() {
        usecase.execute(repo).member.subscribe { m -> member.value = m }
    }
}