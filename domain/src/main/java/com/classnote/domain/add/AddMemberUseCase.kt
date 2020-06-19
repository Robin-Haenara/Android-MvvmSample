package com.classnote.domain.add

import com.classnote.domain.UseCase
import com.classnote.domain.UseCaseInput
import com.classnote.domain.UseCaseNone
import com.classnote.domain.model.KidsnoteMember
import java.lang.Exception

class AddMemberUseCase : UseCase<AddMemberUseCaseInput, UseCaseNone> {
    override fun execute(input: AddMemberUseCaseInput): UseCaseNone {
        when {
            !isVaildName(input.name) -> { throw AddMemberException("이름이 유효하지 않습니다.") }
            !isVaildPart(input.part) -> { throw AddMemberException("파트명이 유효하지 않습니다.") }
            else -> {
                input.repo.addMember(KidsnoteMember(input.name, input.part))
                return UseCaseNone()
            }
        }
    }

    fun isVaildName(name : String) : Boolean {
        return name.isNotBlank()
    }

    fun isVaildPart(part : String) : Boolean {
        return part.isNotBlank()
    }
}


interface AddMemberUseCaseInput : UseCaseInput {
    val name : String
    val part : String
    val repo : AddMemberRepo
}

interface AddMemberRepo {
    fun addMember(member: KidsnoteMember)
}

class AddMemberException(message : String) : Exception(message)