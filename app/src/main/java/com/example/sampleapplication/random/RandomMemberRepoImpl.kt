package com.example.sampleapplication.random

import com.classnote.domain.model.KidsnoteMember
import com.classnote.domain.random.RandomMemberRepo

class RandomMemberRepoImpl(val db : KidsnoteMemberDB) : RandomMemberRepo {
    override val totalMember get() = db.list.size
    override fun getMember(index: Int) = db.list[index]
}

interface KidsnoteMemberDB {
    val list : List<KidsnoteMember>
}
