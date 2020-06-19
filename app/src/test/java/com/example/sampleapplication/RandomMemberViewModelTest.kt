package com.example.sampleapplication

import com.classnote.domain.model.KidsnoteMember
import com.example.sampleapplication.random.RandomMemberViewModel
import io.mockk.MockKAnnotations
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class RandomMemberViewModelTest {
    lateinit var randomMemberViewModel : RandomMemberViewModel
    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        randomMemberViewModel =
            RandomMemberViewModel()
    }


    @Test
    fun getMember() {
        assertTrue(randomMemberViewModel.member.value is KidsnoteMember)
    }

    @Test
    fun getNext() {
        val previous = randomMemberViewModel.member.value
        randomMemberViewModel.getNext()
        val next = randomMemberViewModel.member.value
        assertNotEquals(previous, next)
    }
}