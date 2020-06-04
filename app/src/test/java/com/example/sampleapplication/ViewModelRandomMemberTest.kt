package com.example.sampleapplication

import io.mockk.MockKAnnotations
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class ViewModelRandomMemberTest {
    lateinit var viewModelRandomMember : ViewModelRandomMember
    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        viewModelRandomMember = ViewModelRandomMember()
    }


    @Test
    fun getMember() {
        assertTrue(viewModelRandomMember.member.value is KidsnoteMember)
    }

    @Test
    fun getNext() {
        val previous = viewModelRandomMember.member.value
        viewModelRandomMember.getNext()
        val next = viewModelRandomMember.member.value
        assertNotEquals(previous, next)
    }
}