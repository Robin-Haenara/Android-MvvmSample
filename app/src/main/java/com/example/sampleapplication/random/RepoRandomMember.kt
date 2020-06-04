package com.example.sampleapplication.random

import com.example.sampleapplication.KidsnoteMember

class RepoRandomMember(db : KidsnoteMemberDB) : UseCaseRandomMemberRepo {
    private var index = 0
    private val list = db.list.shuffled()
    override val member get() = list[(index++ % list.size)]
}

interface KidsnoteMemberDB {
    val list : List<KidsnoteMember>
}
