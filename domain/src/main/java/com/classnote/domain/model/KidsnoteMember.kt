package com.classnote.domain.model

data class KidsnoteMember(val name : String, val part : String) {
    override fun toString() = "$name / $part"
}