package com.example.sampleapplication.random

import com.classnote.domain.model.KidsnoteMember
import com.classnote.domain.random.RandomMemberRepo

class RandomMemberRepoImpl(db : KidsnoteMemberDB) : RandomMemberRepo {
    private var index = 0
    private val list = db.list.shuffled()
    override val member get() = list[(index++ % list.size)]
}

interface KidsnoteMemberDB {
    val list : List<KidsnoteMember>
}
