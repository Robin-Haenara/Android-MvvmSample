package com.example.sampleapplication.search

import com.classnote.domain.search.SearchRepo
import com.example.sampleapplication.db.KidsNoteMemberDB
import io.reactivex.rxjava3.core.Observable

class SearchRepoImpl(private val db : KidsNoteMemberDB) : SearchRepo {
    override val list get() = Observable.fromIterable(db.list)
}