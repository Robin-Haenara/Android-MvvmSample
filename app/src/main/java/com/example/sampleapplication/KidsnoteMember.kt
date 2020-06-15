package com.example.sampleapplication

import androidx.databinding.BaseObservable

data class KidsnoteMember(val name : String, val part : String) : BaseObservable() {
    override fun toString() = "$name / $part"
}