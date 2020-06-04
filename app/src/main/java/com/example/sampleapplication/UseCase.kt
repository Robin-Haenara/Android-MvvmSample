package com.example.sampleapplication

interface UseCase<in I : UseCaseInput, out O : UseCaseOutput> {
    fun execute(input : I) : O
}

interface UseCaseInput

interface UseCaseOutput

class UseCaseNone : UseCaseInput, UseCaseOutput
