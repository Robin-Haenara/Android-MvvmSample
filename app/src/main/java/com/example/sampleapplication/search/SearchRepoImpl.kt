package com.example.sampleapplication.search

import com.classnote.domain.search.SearchRepo
import com.example.sampleapplication.random.KidsnoteMemberDB

class SearchRepoImpl(private val db : KidsnoteMemberDB) : SearchRepo {
    override val list get() = db.list
}