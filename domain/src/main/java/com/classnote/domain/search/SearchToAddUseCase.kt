package com.classnote.domain.search

import com.classnote.domain.UseCase
import com.classnote.domain.UseCaseInput
import com.classnote.domain.UseCaseOutput
import com.classnote.domain.const.Navigation

class SearchToAddUseCase : UseCase<SearchToAddUseCaseInput, SearchToAddUseCaseOutput> {
    override fun execute(input: SearchToAddUseCaseInput): SearchToAddUseCaseOutput {
        return object : SearchToAddUseCaseOutput {
            override val keyword = input.keyword?.trim() ?: ""
            override val destination = Navigation.AddFragment(keyword)
        }
    }

}

interface SearchToAddUseCaseInput : UseCaseInput {
    val keyword : String?
}
interface SearchToAddUseCaseOutput : UseCaseOutput {
    val keyword : String
    val destination : Navigation
}