package com.example.sampleapplication.random

import com.classnote.domain.model.KidsnoteMember
import com.classnote.domain.UseCase
import com.classnote.domain.UseCaseInput
import com.classnote.domain.UseCaseOutput

class UseCaseRandomMember :
    UseCase<UseCaseRandomMemberRepo, UseCaseRandomMemberResult> {
    override fun execute(input: UseCaseRandomMemberRepo): UseCaseRandomMemberResult {
        return object : UseCaseRandomMemberResult {
            override val member = input.member
        }
    }
}

interface UseCaseRandomMemberRepo : UseCaseInput {
    val member : KidsnoteMember
}
interface UseCaseRandomMemberResult : UseCaseOutput {
    val member : KidsnoteMember
}