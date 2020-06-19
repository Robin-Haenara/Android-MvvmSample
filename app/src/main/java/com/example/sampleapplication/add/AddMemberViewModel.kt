package com.example.sampleapplication.add

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.classnote.domain.add.AddMemberException
import com.classnote.domain.add.AddMemberRepo
import com.classnote.domain.add.AddMemberUseCase
import com.classnote.domain.add.AddMemberUseCaseInput

class AddMemberViewModel(val usecase: AddMemberUseCase, val repo: AddMemberRepo) : ViewModel() {
    var name = ""
    var part = ""
    val event = MutableLiveData<String>()

    fun addMember() = addMember(name, part)

    private fun addMember(name: String, part: String) {
        try {
            usecase.execute(object : AddMemberUseCaseInput {
                override val name = name
                override val part = part
                override val repo = this@AddMemberViewModel.repo
            })
            event.value = "$name 등록에 성공하였습니다."
        } catch (e: AddMemberException) {
            event.value = e.message
        }
    }
}