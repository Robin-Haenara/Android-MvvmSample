package com.example.sampleapplication.add

import com.classnote.domain.add.AddMemberRepo
import com.classnote.domain.model.KidsnoteMember
import com.example.sampleapplication.db.KidsNoteMemberDB

class AddMemberRepoImpl(private val db: KidsNoteMemberDB) : AddMemberRepo {
    override fun addMember(member: KidsnoteMember) {
        db.list.add(member)
    }
}