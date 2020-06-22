package com.example.sampleapplication.search

import com.classnote.domain.search.SearchRepo
import com.example.sampleapplication.db.KidsNoteMemberDB

class SearchRepoImpl(private val db : KidsNoteMemberDB) : SearchRepo {
    override val list get() = db.list
}