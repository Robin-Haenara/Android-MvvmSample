package com.example.sampleapplication.random

import com.example.sampleapplication.*

class UseCaseRandomMember : UseCase<UseCaseRandomMemberRepo, UseCaseRandomMemberResult> {
    override fun execute(input: UseCaseRandomMemberRepo): UseCaseRandomMemberResult {
        return object : UseCaseRandomMemberResult {
            override val member = input.member
        }
    }
}

interface UseCaseRandomMemberRepo : UseCaseInput {
    val member : KidsnoteMember
}
interface UseCaseRandomMemberResult : UseCaseOutput{
    val member : KidsnoteMember
}