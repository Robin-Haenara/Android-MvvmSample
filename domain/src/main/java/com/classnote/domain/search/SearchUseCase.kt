package com.classnote.domain.search

import com.classnote.domain.model.KidsnoteMember
import com.classnote.domain.UseCase
import com.classnote.domain.UseCaseInput
import com.classnote.domain.UseCaseOutput

class SearchUseCase : UseCase<SearchUseCaseInput, SearchUseCaseOutput> {
    private fun search(input : SearchUseCaseInput) : SearchUseCaseOutput {
        val keyword = input.keyword.trim().toLowerCase()
        return object : SearchUseCaseOutput {
            override val filteredList
                get() = if (keyword.isNotBlank()) {
                    input.repo.list.filter {
                        it.name.toLowerCase().contains(keyword) || it.part.toLowerCase().contains(keyword)
                    }
                } else {
                    input.repo.list
                }
        }
    }

    override fun execute(input: SearchUseCaseInput) = search(input)
}

interface SearchUseCaseInput : UseCaseInput {
    val keyword : String
    val repo : SearchRepo
}

interface SearchUseCaseOutput : UseCaseOutput {
    val filteredList : List<KidsnoteMember>
}

interface SearchRepo {
    val list : List<KidsnoteMember>
}
