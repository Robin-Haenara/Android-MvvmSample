package com.example.sampleapplication.random

import com.classnote.domain.random.RandomMemberRepo
import com.example.sampleapplication.db.KidsNoteMemberDB
import io.reactivex.rxjava3.core.Single

class RandomMemberRepoImpl(val db : KidsNoteMemberDB) : RandomMemberRepo {
    override val totalMember get() = db.list.size
    override fun getMember(index: Int) = Single.just(db.list[index])
}

