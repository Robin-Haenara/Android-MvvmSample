package com.classnote.domain.random

import com.classnote.domain.UseCase
import com.classnote.domain.UseCaseInput
import com.classnote.domain.UseCaseOutput
import com.classnote.domain.model.KidsnoteMember

class RandomMemberUseCase : UseCase<RandomMemberRepo, UseCaseRandomMemberResult> {

    private lateinit var shuffledIndex : List<Int>
    private var lastIndex = 0

    override fun execute(input: RandomMemberRepo): UseCaseRandomMemberResult {
        if (lastIndex == 0) {
            shuffledIndex = (0 until input.totalMember).shuffled()
        }
        val index = shuffledIndex[lastIndex]
        lastIndex = (lastIndex + 1) % shuffledIndex.size
        return object : UseCaseRandomMemberResult {
            override val member = input.getMember(index)
        }
    }
}

interface RandomMemberRepo : UseCaseInput {
    val totalMember : Int
    fun getMember(index : Int) : KidsnoteMember
}
interface UseCaseRandomMemberResult : UseCaseOutput {
    val member : KidsnoteMember
}