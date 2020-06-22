package com.classnote.domain.const

sealed class Navigation {
    class AddFragment(val keyword : String = "") : Navigation()
}