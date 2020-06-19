package com.classnote.domain.random

import com.classnote.domain.model.KidsnoteMember
import com.classnote.domain.UseCase
import com.classnote.domain.UseCaseInput
import com.classnote.domain.UseCaseOutput

class RandomMemberUseCase :
    UseCase<RandomMemberRepo, UseCaseRandomMemberResult> {
    override fun execute(input: RandomMemberRepo): UseCaseRandomMemberResult {
        return object : UseCaseRandomMemberResult {
            override val member = input.member
        }
    }
}

interface RandomMemberRepo : UseCaseInput {
    val member : KidsnoteMember
}
interface UseCaseRandomMemberResult : UseCaseOutput {
    val member : KidsnoteMember
}